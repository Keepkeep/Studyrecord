package com.study.jdk.studysychronized.threed;

/**
 * 创建线程常见的三种方式
 * 1.继承thread
 * 2.实现Runnable方式
 * 3.Executor.newcahedThread (线程池启动的方式启动一个线程)
 */
public class CreateThread {

    static class Mythread extends Thread{
        @Override
        public void run() {
            System.out.println("继承Thread的方式实现线程");
        }
    }

    static  class  Myrun implements  Runnable{

        @Override
        public void run() {
            System.out.println("实现Runable的方式去实现接口");
        }
    }

    public static void main(String[] args) {
        //还可以通过直接lamda方式
        Thread thread = new Thread(() -> {
            System.out.println("通过lamda的方式去创建线程！！！！");
        });
        thread.start();
        new Mythread().start();
        new Myrun().toString();
    }
}
