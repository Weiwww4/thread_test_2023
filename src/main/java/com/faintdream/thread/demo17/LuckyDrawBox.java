package com.faintdream.thread.demo17;

import java.math.BigDecimal;

/**
 * 抽奖箱
 * */
public class LuckyDrawBox implements Runnable{

    /**
     * 奖池
     * */
    private final PrizePool prizePool = new PrizePool();

    @Override
    public void run() {
        while (true){
            if(!lottery()){
                return;
            }
        }
    }

    /**
     * 抽奖
     * */
    private synchronized boolean lottery(){
        try{
            BigDecimal prize = prizePool.lottery();
            System.out.printf("%s又产生了一个%s元大奖\n",Thread.currentThread().getName(),prize);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (RuntimeException e){
            System.out.printf("%s:奖品抽完了\n",Thread.currentThread().getName());
            return false;
        }
        return true;
    }
}
