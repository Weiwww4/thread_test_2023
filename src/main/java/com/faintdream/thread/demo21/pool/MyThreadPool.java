package com.faintdream.thread.demo21.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,              // 核心线程数量(不能小于0)
                6,          //最大线程数(不能小于0,最大数量 >= 核心线程数量)
                60,         // 空闲线程的最大存活时间(不能小于0)
                TimeUnit.SECONDS,                       // 时间单位 (使用TimeUnit指定)
                new ArrayBlockingQueue<>(3),    // 任务队列 (不能为空)
                Executors.defaultThreadFactory(),       // 创建的线程工厂 (不能为空)
                new ThreadPoolExecutor.AbortPolicy()    // 任务的拒绝策略 (不能为空)

        );

        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
    }
}
