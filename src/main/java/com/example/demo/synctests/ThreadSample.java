package com.example.demo.synctests;

import lombok.SneakyThrows;

public class ThreadSample  extends Thread{





    @SneakyThrows
    public void run(){
        System.out.println("1");
        Thread.sleep(5000);
        System.out.println("2");
    }
}
