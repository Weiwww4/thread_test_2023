package com.faintdream.thread.demo02;


public class MyThread01 extends Thread {
    @Override
    public void run() {
        for(int i = 1;i<=10; i++){
            System.out.println(getName() + "@" + i);
        }
    }
}
