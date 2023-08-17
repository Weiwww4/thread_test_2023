package com.faintdream.thread.demo12;

import java.util.concurrent.atomic.AtomicInteger;

public class Window implements Runnable {

    private  AtomicInteger ticket = new AtomicInteger(20);

    @Override
    public void run() {
        while (true) {
            if (ticketing()) break;
        }
    }

    private synchronized boolean ticketing() {
        if (ticket.get() == 0) {
            return true;
        } else {
            ticket.decrementAndGet();
            System.out.printf("%s：成功卖了1张票，还有%s张\n", Thread.currentThread().getName(), ticket);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
