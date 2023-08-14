package com.faintdream.thread.demo03;

public class ThreadDemo {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("线程AA");
        t2.setName("线程BB");

        t1.start();
        t2.start();
    }
}
