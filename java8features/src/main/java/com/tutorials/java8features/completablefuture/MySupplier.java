package main.java.com.tutorials.java8features.completablefuture;

import java.util.function.Supplier;

/**
 * A supplier that sleeps for a second, and then returns one
 **/
public class MySupplier implements Supplier<Integer> {

    @Override
    public Integer get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //Do nothing
        }
        return 1;
    }
}
