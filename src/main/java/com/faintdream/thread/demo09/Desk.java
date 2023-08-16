package com.faintdream.thread.demo09;

/**
 * 控制生产者和消费者的执行
 * */
public class Desk {

    /**
     * foodFlag 是否有面条 0.没有面条(告诉厨师要做面条了) 1.有面条
     * count 总个数(桌子上有几碗面条)
     * lock 锁对象
     * */

    protected static Integer foodFlag = 0;
    protected static Integer count = 10;
    protected static final String lock = "锁";

}
