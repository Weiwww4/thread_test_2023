package com.faintdream.thread.demo13;

public class Window implements Runnable {


    /**
     * 线程共享的数据
     * */
    private  Integer ticket;

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

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }
}
