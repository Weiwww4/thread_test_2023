package com.faintdream.thread.demo10;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{

    private ArrayBlockingQueue<String> queue;

    public ArrayBlockingQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true) {
            // 不断从阻塞队列当中获取面条
            try{
                String food = queue.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
