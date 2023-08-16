package com.faintdream.thread.demo10;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
    private ArrayBlockingQueue<String> queue;

    public ArrayBlockingQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run(){
        // 不断把面条放到阻塞队列当中
        try{
            queue.put("面条");
            System.out.println("厨师放了一碗面条");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
