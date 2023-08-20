package com.faintdream.thread.demo16;

/*
抢红包也用到了多线程。
假设: 100块，分成了3个包，现在有5个人去抢。
其中，红包是共享数据。
5个人是5条线程。
打印结果如下:
XXX抢到了XXX元
XXX抢到了XXX元
XXX抢到了XXX元
XXX没抢到
XXX没抢到

*/
public class ThreadDemo {
    public static void main(String[] args) {

        Integer Number = 5;
        GrabRedEnvelopes[] threads = new GrabRedEnvelopes[Number];

        // 设置红包数量
        GrabRedEnvelopes.setQuantity(3);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new GrabRedEnvelopes();
            switch (i){
                case 0: threads[i].setName("Nahida"); break;
                case 1: threads[i].setName("KLee"); break;
                case 2: threads[i].setName("Amber"); break;
                case 3: threads[i].setName("Keqing"); break;
                case 4: threads[i].setName("HuTao"); break;
            }
        }

        for (int i =0;i<threads.length;i++){
            threads[i].start();
        }

    }

}
