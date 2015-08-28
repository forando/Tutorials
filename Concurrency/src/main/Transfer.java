package main;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by forando on 26.08.15.
 */
public class Transfer implements Callable<Integer> {

    private Account accountFrom;
    private Account accountTo;
    private int amount;
    private String id;
    private CountDownLatch latch;
    private CyclicBarrier barrier;


    public Transfer(Account accountFrom, Account accountTo, int amount, int id,
                    CountDownLatch latch, CyclicBarrier barrier) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.id = "Transfer" + id;
        //Saving id of this thread to be used along this thread all code chain execution
        this.latch = latch;
        this.barrier = barrier;
    }

    @Override
    public Integer call() throws Exception {
        //saving id to ThreadLocal so that it would be accessed in all code down the chain in this thread
        ThreadContextHolder.setThreadID(id);
        System.out.println(id + ": Waiting for start...");
        latch.await();
        System.out.println(id + ": Thread started.");
        long startTime = System.currentTimeMillis();
        boolean result = false;
        if (accountFrom.getBalance() < amount) {
            System.out.println(id + ": ERROR InsufficientFundsException");
            throw new InsufficientFundsException(id + ": InsufficientFundsException");
        }
        int wait = new Random().nextInt(3);
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (accountFrom.getLock().tryLock(wait, TimeUnit.SECONDS)) {
                    try {
                        System.out.println(id + ": Got lock on account" + accountFrom.getId());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (accountTo.getLock().tryLock(wait, TimeUnit.SECONDS)) {
                            try {
                                System.out.println(id + ": Got lock on account" + accountTo.getId());
                                System.out.println(id + ": Transaction began.");
                                accountFrom.withdraw(amount);
                                accountTo.deposit(amount);
                                Thread.sleep(new Random().nextInt(1000));
                                System.out.println(id + ": Transaction finished successfully!");
                                result = true;
                            } catch (Exception ex){
                                ex.printStackTrace();
                            }finally {
                                accountTo.getLock().unlock();
                                System.out.println(id + ": Unlocking account" + accountTo.getId());
                            }
                        } else {
                            System.out.println(id + ": Transaction canceled!");
                            accountFrom.incFailedTransferCount();
                            accountTo.incFailedTransferCount();
                        }
                    } finally {
                        accountFrom.getLock().unlock();
                        System.out.println(id + ": Unlocking account" + accountFrom.getId());
                    }
                } else {
                    System.out.println(id + ": Transaction canceled!");
                    accountFrom.incFailedTransferCount();
                    accountTo.incFailedTransferCount();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (result == false);
        long endTime = System.currentTimeMillis();
        System.out.println(id + ": Thread finished.");
            if (accountFrom.getId() == 2) barrier.await();
        return (int)(endTime - startTime)/1000;
    }
}
