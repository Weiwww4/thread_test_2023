package com.faintdream.thread.demo11;

public class Window implements Runnable {

    private static Integer ticket = 1000;

    @Override
    public void run() {
        while (true) {
            if (ticketing()) break;
        }
    }

    private synchronized boolean ticketing() {
        if (ticket == 0) {
            return true;
        } else {
            ticket--;
            System.out.printf("%s：成功卖了1张票，还有%d张\n", Thread.currentThread().getName(), ticket);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
