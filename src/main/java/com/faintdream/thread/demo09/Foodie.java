package com.faintdream.thread.demo09;

/**
 * 消费者
 * */
public class Foodie extends Thread{
    @Override
    public void run(){
        /**
         * 1.循环
         * 2.同步代码块
         * 3.判断共享数据是否到了末尾（到了末尾）
         * 4.判断共享数据是否到了末尾（没有到末尾，执行核心代码）
         * */

        while (true){

            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else{
                    // 先判断桌子上有几碗面条
                    // 如果没有面条，就等待
                    // 如果有，就开吃
                    // 吃完之后，唤醒厨师继续做
                    // 把吃的总数-1
                    // 修改桌子的状态


                    // 先判断桌子上有几碗面条
                    if(Desk.foodFlag == 0){
                        // 如果没有面条，就等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {// 如果有，就开吃
                        // 把吃的总数-1
                        Desk.count--;
                        System.out.printf("吃货在吃面条，还能再吃%d碗\n",Desk.count);

                        // 吃完之后，唤醒厨师继续做
                        Desk.lock.notifyAll();

                        // 修改桌子的状态
                        Desk.foodFlag = 0;
                    }
                }
            }
        }

    }
}
