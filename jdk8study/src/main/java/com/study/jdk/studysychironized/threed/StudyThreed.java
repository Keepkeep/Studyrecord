package com.study.jdk.studysychironized.threed;

import java.util.concurrent.TimeUnit;

/**
 *理解线程
 * 线程不能直接调用对象的run方法
 */
public class StudyThreed extends  Thread {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StudyThreed studyThreed = new StudyThreed();
        studyThreed.start();;
        for (int i = 0; i < 50; i++) {
            TimeUnit.MICROSECONDS.sleep(1);
            System.out.println("主线程main");
        }
    }
}
