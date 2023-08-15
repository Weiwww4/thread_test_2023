package com.faintdream.thread.demo07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread{

    private static int ticket = 0;
    private static final Lock lock = new ReentrantLock();
    @Override
    public void run(){

        while(true){

            lock.lock();

            try {

                if (ticket == 100) {
                    break;
                } else {
                    Thread.sleep(100);
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
