package com.faintdream.thread.demo14;

/**
 * 有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出。
 * 利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
 * */
public class ThreadDemo {


    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();

        t1.setName("纳西妲");
        t2.setName("可莉");

        t1.start();
        t2.start();
    }
}
