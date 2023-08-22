package com.faintdream.thread.demo21.pool;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.printf("%s执行了...\n",Thread.currentThread());
    }
}
