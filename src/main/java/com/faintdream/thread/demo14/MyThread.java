package com.faintdream.thread.demo14;

public class MyThread extends Thread {

    protected static Integer ticket = 20;

    protected static final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket <= 10) {
                    System.out.println(getName() + ":礼物已经送完，不再售买");
                    break;
                } else {
                    ticket--;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":送出1份礼物,还有" + ticket + "份");
                }
            }
        }
    }
}
