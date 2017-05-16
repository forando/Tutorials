package com.tutorials.java8features.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new MySupplier(), exec);
        System.out.println(f.isDone()); // False
        CompletableFuture<Integer> fResult = f.thenApply(new PlusOne());
        System.out.println("Waiting for calculation complete...");
        try {
            System.out.println(fResult.get()); // Waits until the "calculation" is done, then prints 2
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            exec.shutdown();
        }
    }
}
