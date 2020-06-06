package com.study.jdk.studysychronized.studysychronized;


import lombok.Synchronized;

public class Sychironized implements  Runnable{

    private int  count=100;

    private Object object = new Object();
    public static void main(String[] args) {
        Sychironized sychironized = new Sychironized();
        for (int i = 0; i < 100; i++) {
            new Thread(sychironized,"curentThread"+i).start();
        }

    }

    public void  add(){
        //sychronized必须拿到对象的锁可以使new 一个对象 或者的当前的类 this  或者类.class
        //请勿使用string字符串作为锁对象
        synchronized (object){
            count--;
            System.out.println(Thread.currentThread().getName() + "count" + count);
        }
    }
    //直接 在方法上使用sychrionized 修饰 替代上面的
    public synchronized   void  add2(){
        count--;
        System.out.println(Thread.currentThread().getName() + "count" + count);
    }


    //这样的代码存在多个线程不能读到 别的线程中 存现  数据输出一样的
    @Override
    public void run() {
        //Sychironized sy = new Sychironized();
        count--;
        System.out.println(Thread.currentThread().getName()+ "count: " + count);
    }
    /**
     *sychronized 是可重入锁
     */
    //场景1: 父子类   父类同步方法  子类从写
    //锁的的是子类的对象

    //场景2：同步方法调用同一个对象的同步方法  是可重入的


    //场景3 ：异常锁  默认情况下锁会被释放
    // 若存在多个等待线程  将被乱入

}
