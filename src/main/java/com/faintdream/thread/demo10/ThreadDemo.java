package com.faintdream.thread.demo10;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 需求:利用阻塞队列完成生产者和消费者
         * 细节:生产者和消费者必须在一个队列
         * */

        // 1.创建阻塞队列的对象
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        // 2.创建线程对象
        Cook c = new Cook();
        Foodie f = new Foodie();

        // 3.把阻塞队列传递进去
        c.setQueue(queue);
        f.setQueue(queue);

        // 4*.设置为守护线程
        c.setDaemon(true);
        f.setDaemon(true);

        // 5.开启线程
        c.start();
        f.start();

        Thread.sleep(30*1000);
    }
}
