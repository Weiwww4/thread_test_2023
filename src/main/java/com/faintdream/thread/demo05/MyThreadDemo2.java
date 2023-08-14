package com.faintdream.thread.demo05;

import com.faintdream.thread.demo05.MyThread;

public class MyThreadDemo2 {
    public static void main(String[] args) {

        /**
         * 需求:
         * 某电影院目前正在上营国内大片，共100张票，有三个窗口
         * */

        // 创建线程对象
        Thread t1 = new MyThread02();
        Thread t2 = new MyThread02();
        Thread t3 = new MyThread02();

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
