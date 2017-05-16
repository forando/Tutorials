package main.java.com.tutorials.java8features.completablefuture;

import java.util.function.Function;

/**
 * A (pure) function that adds one to a given Integer
 **/
public class PlusOne implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return x + 1;
    }
}
