package com.faintdream.thread.demo06;

public class MyRunnable1 implements Runnable{

    private Integer ticket = 0;
    @Override
    public void run() {


        while(true){
            synchronized (MyRunnable1.class){
                if(ticket == 100){
                    break;
                } else{
                    ticket++;
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}


// 多线程代码写法 4部
// 1.循环
// 2.同步代码块
// 3.判断共享数据是否到了末尾，如果到了末尾
// 4.判断共享数据是否到了末尾，如果没有到末尾