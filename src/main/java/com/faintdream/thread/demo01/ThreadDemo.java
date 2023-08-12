package com.faintdream.thread.demo01;

public class ThreadDemo {

    /*
    * 线程优先级 1 - 10 默认为5
    * setPriority(int newPriority) 设置线程的优先级
    * int getPriority() 获取线程的优先级
    * */

    public static void main(String[] args) {

        // 创建线程对象
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr,"测试1");
        Thread t2 = new Thread(mr,"测试2");

        // 默认的线程优先级 5
        System.out.println(t1.getName() + "(线程)优先级:" + t1.getPriority());
        System.out.println(t2.getName() + "(线程)优先级:" + t1.getPriority());
        System.out.println(Thread.currentThread().getName() + "(线程)优先级:" + Thread.currentThread().getPriority());

        // 设置线程优先级
        t1.setPriority(10);
        t2.setPriority(1);

        // 启动线程
        t1.start();
        t2.start();
    }
}
