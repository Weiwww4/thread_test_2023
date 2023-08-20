package com.faintdream.thread.demo15;

public class MyRunnable implements Runnable {

    private Integer num;

    @Override
    public void run() {
        while (true) {
            if (exec()) break;

        }
    }

    private synchronized boolean exec() {
        if (num == 0) {
            return true;
        } else {
            if (num % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + num);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
        }
        return false;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
