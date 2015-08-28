package main;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by forando on 26.08.15.
 */
public class Account {
    private int balance;

    private int id;

    private Lock lock;

    private AtomicInteger failCounter;

    public Account(int balance, int id) {
        this.balance = balance;
        this.id = id;
        this.lock = new ReentrantLock();
        this.failCounter = new AtomicInteger(0);
    }

    public void withdraw(int amount){
        balance -= amount;
        /*
        This code is run in each thread separately.
        So, from here we can access all ThreadLocal variables that belong to the thread.
         */
        System.out.println(ThreadContextHolder.getThreadID() + "_acc" + id + ": withdrawn " + amount);
    }

    public void deposit(int amount){
        balance += amount;
        /*
        This code is run in each thread separately.
        So, from here we can access all ThreadLocal variables that belong to the thread.
         */
        System.out.println(ThreadContextHolder.getThreadID() + "_acc" + id + ": deposited " + amount);
    }

    public int getBalance(){
        return balance;
    }

    public int getId(){
        return id;
    }

    public Lock getLock(){
        return lock;
    }

    public void incFailedTransferCount(){
        failCounter.incrementAndGet();
    }

    public int getFailedTransferCount(){return  failCounter.get();}
}
