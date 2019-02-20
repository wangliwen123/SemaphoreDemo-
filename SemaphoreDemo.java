package com.example.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6; i++)
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "已经抢到了");
                    //暂停3秒钟
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
    }
}
