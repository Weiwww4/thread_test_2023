package com.faintdream.thread.demo09;

public class Cook extends Thread{

    @Override
    public void run(){


        // 判断桌子上是否有食物
        // 如果有，就等待
        // 如果没有，就制作食物
        // 修改桌子上的食物状态
        // 叫醒等待的消费者开吃

        while (true){
            synchronized (Desk.lock) {
                if(Desk.count == 0){
                    break;
                }
                else {
                    // 判断桌子上是否有食物
                    if(Desk.foodFlag == 1){
                        // 如果有，就等待
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        // 如果没有，就制作食物
                        System.out.println("厨师做了一碗面条");

                        // 修改桌子上的食物状态
                        Desk.foodFlag = 1;

                        // 叫醒等待的消费者开吃
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
