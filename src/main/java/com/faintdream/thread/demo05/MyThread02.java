package com.faintdream.thread.demo05;

public class MyThread02 extends Thread{

    // 表示这个类的所有对象，都共享ticket数据
    private static int ticket = 0; // 0`99

    // 锁对象
    private static final Object obj = new Object();

    @Override
    public void run(){
        while (true){
            synchronized (obj){
                if(ticket<100){
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
    }
}
