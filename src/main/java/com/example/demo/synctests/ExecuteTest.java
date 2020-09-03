package com.example.demo.synctests;

public class ExecuteTest {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        /*Example example = new Example();
        Example example1 = new Example();

        Thread thread = new Thread(() -> Example.print5());
        thread.start();
        thread.start();

       *//* Thread thread2 = new Thread(() -> Example.print6());
        thread2.start();
        Field field = thread.getClass().getDeclaredField("daemon");
        field.setAccessible(true);
        field.set(thread2, true);


        thread.join();
        thread2.join();
        System.out.println("end");*//*
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.incrementAndGet();
        atomicInteger.decrementAndGet();
        atomicInteger.addAndGet(10);
        atomicInteger.addAndGet(-10);


        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Wolrd");

        Object [] array = list.toArray();
        array[0]=null;
        System.out.println(list);*/

        recursive(100000);
       /* for (int i = 0; i < 10; i++) {
            String s = "hello";
            System.out.println(s + " : " + i);
        }*/
    }


    public static void recursive(int count) {
        if (count > 0) {
            String s = "hello";
            System.out.println(s + " : " + count);
            recursive1(--count);

        }

        System.out.println("count : " + count);

    }

    public static void recursive1(int count) {
        if (count > 0) {
            String s = "hello";
            System.out.println(s + " : " + count);
            recursive2(--count);

        }

        System.out.println("count : " + count);

    }

    public static void recursive2(int count) {
        if (count > 0) {
            String s = "hello";
            System.out.println(s + " : " + count);
            recursive3(--count);

        }

        System.out.println("count : " + count);

    }

    public static void recursive3(int count) {
        if (count > 0) {
            String s = "hello";
            System.out.println(s + " : " + count);
            recursive3(--count);

        }

        System.out.println("count : " + count);

    }
}

