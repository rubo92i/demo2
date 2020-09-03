package com.example.demo.synctests;

import java.util.concurrent.locks.ReentrantLock;

public class Example {


    private ReentrantLock lock = new ReentrantLock();

    public void print() {

        try {

            while (lock.isLocked()) {
                Thread.sleep(10);
            }
            lock.lock();

            System.out.println("print step1");
            Thread.sleep(5000);
            System.out.println("print step2");

            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public void print2() {
        synchronized (this) {
            System.out.println("print2 step1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("print2 step2");
        }

    }

    public synchronized void print3() {
        System.out.println("print3 step1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print3 step2");
    }

    public synchronized void print4() {
        System.out.println("print4 step1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print4 step2");
    }


    public static void print5() {
        synchronized (Example.class) {
            System.out.println("print5 step1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("print step2");
        }

    }


    public static void print6() {
        synchronized (Example.class) {
            System.out.println("print6 step1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("print6 step2");
        }
    }

    public static synchronized void print7() {

        System.out.println("print7 step1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print7 step2");

    }

    public static synchronized void print8() {
        System.out.println("print8 step1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("print8 step2");
    }


}
