package com.faintdream.thread.demo03;

public class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 1;i<=100;i++){
            System.out.println(getName()+"@" + i);

            // 表示出让当前CPU的执行权
            Thread.yield();
        }
    }
}
