package com.faintdream.thread.demo05;

public class MyThreadDemo {
    public static void main(String[] args) {

        /**
         * 需求:
         * 某电影院目前正在上营国内大片，共100张票，有三个窗口
         * */

        // 创建线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        // 起名字
        t1.setName("窗口A");
        t2.setName("窗口B");
        t3.setName("窗口C");

        // 开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}
