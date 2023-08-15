package com.faintdream.thread.demo06;

public class MyThreadDemo {

    public static void main(String[] args) {

        Runnable myRunnable = new MyRunnable1();

        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        Thread t3 = new Thread(myRunnable);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
