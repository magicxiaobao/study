package com.rokey.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyuejun
 * @create 2017-08-26 下午2:17.
 */
public class LockDemo1
{

    private static  ReentrantLock lock = new ReentrantLock();

    private static  int num =0;

    private static long start =0;

     static class ThreadA extends Thread{
        @Override
        public void run() {

            for(int i=0;i<100;){
                lock.lock();
                if(num%3==0){
                    System.out.println("A");
                    num++;
                    i++;
                }
                lock.unlock();
            }

        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;){
                lock.lock();
                if(num%3==1){
                    System.out.println("B");
                    num++;
                    i++;
                }
                lock.unlock();
            }

        }
    }
     static class ThreadC extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;){
                lock.lock();
                if(num%3==2){
                    System.out.println("C");
                    num++;
                    i++;
                    if(i==100){
                        System.out.println("任务总共花费时间="+(System.currentTimeMillis()-start));
                    }
                }
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) {
          start = System.currentTimeMillis();
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();

    }

}
