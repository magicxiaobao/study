package com.rokey.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyuejun
 * @create 2017-08-27 下午4:30.
 */
public class ConditionDemo {


    private static ReentrantLock lock = new ReentrantLock();

    private static int count =0;

    private static long start=0;

    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();


    static class ThreadA extends Thread{
        @Override
        public void run() {

            try {
                lock.lock();
                for(int i=0;i<100;i++){

                    while(count%3!=0){
                        a.await();//释放锁
                    }
                    System.out.println("A");
                    count++;
                    b.signal();//唤醒B
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }

    static class ThreadB extends Thread{

        @Override
        public void run() {

            try {
                lock.lock();
                for(int i=0;i<100;i++){

                    while(count%3!=1){
                        b.await();//释放锁
                    }
                    System.out.println("B");
                    count++;
                    c.signal();//通知c
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }

    static class ThreadC extends Thread{

        @Override
        public void run() {

            try {
                lock.lock();
                for(int i=0;i<100;i++){

                    while(count%3!=2){
                        c.await();
                    }
                    System.out.println("C");
                    count++;
                    if(i==99){
                        System.out.println("总共花时间:"+(System.currentTimeMillis()-start));
                    }
                    a.signal();//通知A
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        }
    }

    public static void main(String[] args) {

        start = System.currentTimeMillis();
        new ThreadA().start();
        new ThreadB().start();
        ThreadC threadC = new ThreadC();
        threadC.start();
        try {
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count数量"+count);

    }

}
