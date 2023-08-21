package com.faintdream.thread.demo19;

import java.math.BigDecimal;

/**
 * 抽奖箱
 */
public class LuckyDrawBox implements Runnable {

    /**
     * 奖池
     */
    private final PrizePool prizePool = new PrizePool();

    /**
     * 两个抽奖箱分别累计获得的奖金数量
     */
    private BigDecimal prize1 = new BigDecimal(0);
    private BigDecimal prize2 = new BigDecimal(0);

    /**
     * 两个抽奖箱分别获取奖金的最大值
     */
    private BigDecimal prize1Max = new BigDecimal(0);
    private BigDecimal prize2Max = new BigDecimal(0);

    /**
     * 循环轮数
     */
    private Integer count = 0;

    @Override
    public void run() {
        while (true) {
            if (!lottery()) {
                return;
            }
        }
    }

    /**
     * 抽奖
     */
    private synchronized boolean lottery() {
        try {
            BigDecimal prize = prizePool.lottery();
            // System.out.printf("%s又产生了一个%s元大奖\n",Thread.currentThread().getName(),prize);

            if (Thread.currentThread().getName().equals("抽奖箱1")) {
                prize1 = prize1.add(prize);
                // System.err.println("1：" + prize);
                if (prize1Max.compareTo(prize) < 0) {
                    prize1Max = prize;
                }
                // System.out.println("1");
                this.notifyAll();
                this.wait();
            } else if (Thread.currentThread().getName().equals("抽奖箱2")) {
                prize2 = prize1.add(prize);
                // System.err.println("2：" + prize);
                if (prize2Max.compareTo(prize) < 0) {
                    prize2Max = prize;
                }
                // System.out.println("2");
                this.notifyAll();
                this.wait();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (RuntimeException e) {
            // System.out.printf("%s:奖品抽完了\n",Thread.currentThread().getName());
            if (Thread.currentThread().getName().equals("抽奖箱1")) {
                System.out.printf("%s:奖品抽完了,一共抽到了%s元,最高奖项%s元\n", Thread.currentThread().getName(), prize1,prize1Max);
                if(prize1Max.compareTo(new BigDecimal(800)) == 0){
                    System.out.printf("%s:抽到了最大的奖项\n",Thread.currentThread().getName());
                }
                this.notifyAll();
            } else if (Thread.currentThread().getName().equals("抽奖箱2")) {
                System.out.printf("%s:奖品抽完了,一共抽到了%s元,最高奖项%s元\n", Thread.currentThread().getName(), prize2,prize2Max);
                if(prize2Max.compareTo(new BigDecimal(800)) == 0){
                    System.out.printf("%s:抽到了最大的奖项\n",Thread.currentThread().getName());
                }
                this.notifyAll();
            }
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
