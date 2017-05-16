package com.tutorials.spring.quoters;

public class T1000 extends TerminatorQuoter implements Quoter {

    @Override
    public void sayQuote() {
        System.out.println("Я жидкий...");
    }
}
