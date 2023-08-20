package com.faintdream.thread.demo17;

/**
 * 有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为
 * {10,5,20,50,100,200,500,800,2,80,300,700};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2"
 * 随机从抽奖池中获取奖项元素并打印在控制台.上,格式如下:
 * 每次抽出一个奖项就打印- -个(随机)
 * 抽奖箱1又产生了一个10元大奖
 * 抽奖箱1又产生了- -个100元大奖
 * 抽奖箱1又产生了一个200元大奖
 * 抽奖箱1又产生了一个800元大奖
 * 抽奖箱2又产生了一个700元大奖.
 * */
public class MyThreadDemo {
    public static void main(String[] args) {
        LuckyDrawBox luckyDrawBox = new LuckyDrawBox();

        Thread t1 = new Thread(luckyDrawBox);
        Thread t2 = new Thread(luckyDrawBox);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        t1.start();
        t2.start();
    }
}