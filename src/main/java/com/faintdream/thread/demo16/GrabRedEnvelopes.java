package com.faintdream.thread.demo16;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GrabRedEnvelopes extends Thread{

    // 红包数量
    protected static Integer quantity = 3;

    // 红包金额(余额)
    protected static BigDecimal balance = new BigDecimal(100);

    public boolean stealing(){
        synchronized (GrabRedEnvelopes.class) {

            if(quantity <=0 ){
                System.out.printf("%s:没有抢到红包\n",getName());
                return false;
            }else if(quantity == 1){// 最后一个红包，钱都给它
                System.out.printf("%s:抢到了红包，抢到了%s块钱\n",getName(),balance);
                balance = balance.subtract(balance);
                quantity--;
                return true;
            }
            else {
                BigDecimal b = calc(balance);
                balance = balance.subtract(b);
                System.out.printf("%s:抢到了红包，抢到了%s块钱\n",getName(),b);

                quantity--;
                return true;
            }
        }

    }

    @Override
    public void run(){
        stealing();
    }

    /**
     * 计算抢到多少钱
     * */
    public BigDecimal calc(BigDecimal balance){

        double randomNumber = Math.random() * balance.doubleValue();
        BigDecimal temp = BigDecimal.valueOf((int)(randomNumber * 100));
        return temp.divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP);
    }


    public static Integer getQuantity() {
        return quantity;
    }

    public static void setQuantity(Integer quantity) {
        GrabRedEnvelopes.quantity = quantity;
    }


    public static BigDecimal getBalance() {
        return balance;
    }

    public static void setBalance(BigDecimal balance) {
        GrabRedEnvelopes.balance = balance;
    }
}
