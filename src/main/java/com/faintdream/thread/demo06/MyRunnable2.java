package com.faintdream.thread.demo06;

public class MyRunnable2 implements Runnable{

    private Integer ticket = 0;
    @Override
    public void run() {


        while(true){
            synchronized (MyRunnable2.class){
                if (sellingTickets()) break;
            }
        }
    }

    private boolean sellingTickets() {
        if(ticket == 100){
            return true;
        } else{
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}

