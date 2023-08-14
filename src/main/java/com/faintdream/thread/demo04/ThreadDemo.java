package com.faintdream.thread.demo04;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        /*
         * public final void join() 插入线程/插队线程
         *
         * */

        MyThread t = new MyThread();
        t.setName("线程AA");
        t.start();

        t.join();

        // 执行在main线程当中的代码
        for(int i = 0; i< 10; i++){
            System.out.println("Main线程" + "@" + (i+1));
        }
    }
}
