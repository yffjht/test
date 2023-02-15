package com.example.de;

import java.util.Random;

/**
 * 解决三个人买十张票不会出现重复买票
 */
public class SynchiozedTest implements Runnable{
    //定义票的总数
    private int num=10;
    //创建，买票的方法
    public synchronized void testMP(){
        if(num>0){
            num--;
            System.out.println(Thread.currentThread().getName()+"剩余总票"+num);
            try {
//                Random random = new Random();
//                int i = random.nextInt(10)*100;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
//        调用买票方法
        for (int i=0;i<10;i++){
            testMP();
        }

    }
}
//开启线程
class ThreadTest{
    public static void main(String[] args) {
        SynchiozedTest synchiozedTest = new SynchiozedTest();
        new Thread(synchiozedTest,"线程一").start();
        new Thread(synchiozedTest,"线程二").start();
        new Thread(synchiozedTest,"线程三").start();
        new Thread(synchiozedTest,"线程si").start();
        System.out.println("tt分支");
        System.out.println("修改过的代码");
    }
}
