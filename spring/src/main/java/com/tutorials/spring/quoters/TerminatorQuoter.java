package com.tutorials.spring.quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min=2, max=7)
    private int repeate;

    private String message;

    public TerminatorQuoter(){
        System.out.println("Phase 1: nothing is ready");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2: All dependencies for an object/bean of this class are injected");
        System.out.println("repeate = " + repeate);
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3: The object/bean of this class is created completely.");
        for (int i = 0; i < repeate; i++) {
            System.out.println("message = " + message);
        }
    }

    /**
     * Для того чтоб настраивать все через xml обязательно нужны сеттеры.
     * Spring через Reflection попытается вызвать сеттер вызвать и если его нет,
     * он упадет.
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
