package com.faintdream.thread.demo19;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 奖池 * 使用list集合表示
 */
public class PrizePool {
    protected List<BigDecimal> prizes = new LinkedList<>();

    public PrizePool() {
        init1();
    }

    //* {10,5,20,50,100,200,500,800,2,80,300,700};
    private void init1() {
        add(10);
        add(5);
        add(20);
        add(50);
        add(100);
        add(200);
        add(500);
        add(800);
        add(2);
        add(80);
        add(300);
        add(700);
    }

    /**
     * 为奖池添加一份奖品(现金奖励)
     */
    protected void add(Integer prize) {
        prizes.add(new BigDecimal(prize));
    }

    /**
     * 奖池中有多少奖品
     */
    protected Integer getPrizesNum() {
        return prizes.size();
    }

    /**
     * 抽奖
     */
    protected synchronized BigDecimal lottery() {
        Random random = new Random();
        int randomNumber = random.nextInt(getPrizesNum()); // 生成0-奖品数之间的随机整数

        if(prizes.size()==0){
            throw new RuntimeException("奖品已抽完...");
        }
        BigDecimal prize = prizes.get(randomNumber);
        prizes.remove(randomNumber);

        return prize;
    }


    protected BigDecimal getMaxPrize(){
        BigDecimal temp = prizes.get(0);
        for(int i =0;i<prizes.size();i++){
            if(temp.compareTo(prizes.get(i))<0){
                temp = prizes.get(i);
            }
        }
        return temp;
    }
}
