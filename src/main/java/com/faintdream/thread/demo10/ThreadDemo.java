package com.faintdream.thread.demo10;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {
        /**
         * 需求:利用阻塞队列完成生产者和消费者
         * 细节:生产者和消费者必须在一个队列
         * */

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
    }
}
