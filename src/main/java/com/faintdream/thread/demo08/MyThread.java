package com.faintdream.thread.demo08;

public class MyThread extends Thread {
    private final static Object lockA = new Object();
    private final static Object lockB = new Object();


    @Override
    public void run() {
        while (true) {
            if ("线程A".equals(getName())) {
                synchronized (lockA) {
                    System.err.println("线程A拿到了A锁,准备拿B锁");
                    synchronized (lockB) {
                        System.err.println("线程A拿到了B锁，顺利执行");
                    }
                }
            } else if ("线程B".equals(getName())) {

                synchronized (lockB) {
                    System.err.println("线程B拿到了B锁,准备拿A锁");
                    synchronized (lockA) {
                        System.err.println("线程B拿到了A锁，顺利执行");
                    }
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(getName());
            }
        }
    }
}
