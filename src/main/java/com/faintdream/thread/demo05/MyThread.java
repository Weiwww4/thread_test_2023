package com.faintdream.thread.demo05;

public class MyThread extends Thread{

    // 表示这个类的所有对象，都共享ticket数据
    private static int ticket = 0; // 0`99

    @Override
    public void run(){
        while (ticket<100){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(getName() + "正在买第" + ticket + "票");
        }
    }
}
