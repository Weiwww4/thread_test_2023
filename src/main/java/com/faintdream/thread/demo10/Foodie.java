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
}
