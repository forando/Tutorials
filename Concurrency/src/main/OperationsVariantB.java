package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by forando on 27.08.15.
 */
public class OperationsVariantB {

    CyclicBarrier barrier;

    public static void main(String[] args) {

        System.out.println("The program has been started.");

        OperationsVariantB operations = new OperationsVariantB();

        final Account a = new Account(1000, 1);
        final Account b = new Account(1000, 2);

        int threads = 10;

        CountDownLatch latch = new CountDownLatch(1);

        operations.barrier = new CyclicBarrier(threads/2, new Runnable() {
            @Override
            public void run() {
                System.out.println("-----------------------------------");
                System.out.println("All b to a transactions finished!!!");
                System.out.println("-----------------------------------");
            }
        });

        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);

        scheduledService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("CURRENT FAILS = " + a.getFailedTransferCount());
            }}, 1, 1, TimeUnit.SECONDS);

        ExecutorService executor = Executors.newFixedThreadPool(5);


        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();


        Random random = new Random();
        int parties = 0;
        for (int i=0; i<threads; i++){
            if (i%2 > 0) {
                futures.add(executor.submit(new Transfer(a, b, random.nextInt(500), i, latch, operations.barrier)));
            }else{
                futures.add(executor.submit(new Transfer(b, a, random.nextInt(500), i, latch, operations.barrier)));
                parties++;
            }
        }



        //Starting all threads synchronously
        latch.countDown();

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
            scheduledService.shutdown();
            System.out.println("All threads are shut down!!!");
            System.out.println("");
            System.out.println("============RESULTS=============");
            for (int i=0; i<threads; i++){
                Future<Integer> future = futures.get(i);
                try {
                    System.out.println("Tread" + i + " Finished in " + future.get() + " sec");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("");
            System.out.println("Account a = " + a.getBalance());
            System.out.println("Account b = " + b.getBalance());
            System.out.println("Account a + b = " + (a.getBalance()+ b.getBalance()));
            System.out.println("Account a fails = " + a.getFailedTransferCount());
            System.out.println("Account b fails = " + b.getFailedTransferCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
