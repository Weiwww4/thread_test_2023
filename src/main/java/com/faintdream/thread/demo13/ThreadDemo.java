package com.faintdream.thread.demo13;

/**
 * 一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
 * 要求:请用多线程模拟卖票过程并打印剩余电影票的数量
 * */
public class ThreadDemo {

    private static Integer Ticket = 1000;
    public static void main(String[] args) {

        Window window = new Window();
        Integer i = 20;
        window.setTicket(i);

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");

        t1.start();
        t2.start();
    }
}
