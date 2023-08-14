package com.faintdream.thread.demo02;

public class ThreadDemo {
    public static void main(String[] args) {
        /*
        * final void setDaemon(boolean on) 设置守护线程
        * 其他线程执行结束后，守护线程也好陆续结束
        *
        * */

        MyThread01 t1 = new MyThread01();
        MyThread02 t2 = new MyThread02();

        t1.setName("正常线程");
        t2.setName("守护线程");

        // t2设置为守护线程
        t2.setDaemon(true);

        t1.start();
        t2.start();

        // 主线程的代码
        for(int i = 1; i<= 100;i++){
            System.out.println("主线程" + "@" + i);
        }
    }
}
