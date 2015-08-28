package main;

import java.util.concurrent.TimeUnit;

/**
 * Created by forando on 26.08.15.
 */
public class OperationsVariantA {

    public static void main(String[] args) {

        final Account a = new Account(1000, 1);
        final Account b = new Account(2000, 2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                transfer(a, b, 500, 2);
            }
        }).start();

        transfer(b, a, 300, 1);
    }

    static void transfer(Account acc1, Account acc2, int amount, long wait) throws InsufficientFundsException{
        if (acc1.getBalance() < amount) throw new InsufficientFundsException();

        try {
            if (acc1.getLock().tryLock(wait, TimeUnit.SECONDS)){
                try {
                    System.out.println("Got lock on account" + acc1.getId());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (acc2.getLock().tryLock(wait, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Got lock on account" + acc2.getId());
                            acc1.withdraw(amount);
                            acc2.deposit(amount);
                            System.out.println("Transfer successful!");
                        }finally {
                            acc2.getLock().unlock();
                            System.out.println("Unlocking account" + acc2.getId());
                        }
                    } else {
                        System.out.println("Transfer canceled!");
                        acc1.incFailedTransferCount();
                        acc2.incFailedTransferCount();
                    }
                }finally {
                    acc1.getLock().unlock();
                    System.out.println("Unlocking account" + acc1.getId());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
