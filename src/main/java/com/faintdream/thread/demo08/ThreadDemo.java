package com.faintdream.thread.demo08;

public class ThreadDemo {
    public static void main(String[] args) {

        /*
         死锁
        **/
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();

        t1.setName("线程A");
        t2.setName("线程B");
        t3.setName("线程C");

        t1.start();
        t2.start();
        t3.start();
    }
}
