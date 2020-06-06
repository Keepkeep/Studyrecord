package com.study.jdk.studysychironized.threed;

import java.util.concurrent.TimeUnit;

/**
 * 使用thread类的常见方法
 *
 */
public class UserThreadMethod{
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                    System.out.println("T1执行" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                    //加入执行线程1
                    thread1.join();
                    System.out.println("T2执行" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                    //加入执行线程3
                    thread2.join();
                    System.out.println("T3执行" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //使用join的方法
        useJoin(thread1,thread2,thread3);
    }
    //上面创建三个线程
    //join方法的使用
    public static   void  useJoin(Thread T1,Thread T2,Thread T3) throws InterruptedException {
        //T1.start();
        //T2.start();
        T3.start();
        T2.start();
        T1.start();
    }
}
