package com.faintdream.thread.demo15;

import com.faintdream.thread.demo06.MyRunnable1;

public class ThreadDemo {
    /**
     * 同时开启两个线程，共同获取1-100之间的所有数字。
     * 要求:将输出所有的奇数。
     * */
    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        MyRunnable m = (MyRunnable)myRunnable;
        m.setNum(100);

        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);

        t1.setName("线程A");
        t2.setName("线程B");

        t1.start();
        t2.start();
    }
}
