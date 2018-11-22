package com.rokey.concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 控制某个方法支持的并发线程数量
 * @author chenyuejun
 * @create 2017-08-27 下午11:52.
 */
public class SemaphoreDemo {


    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(1);
    private static Semaphore semaphoreC = new Semaphore(1);


    static class ThreadA extends Thread{
        @Override
        public void run() {

            try {
                for(int i=0;i<10;i++){
                    semaphoreA.acquire();
                    System.out.println("A");
                    semaphoreB.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                for(int i=0;i<10;i++){
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   static class ThreadC extends Thread {
       @Override
       public void run() {

           try {
               for(int i=0;i<10;i++){
                   semaphoreC.acquire();
                   System.out.println("C");
                   semaphoreA.release();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }


    public static void main(String[] args) throws InterruptedException {

        semaphoreB.acquire();
        semaphoreC.acquire();
        new ThreadA().start();
        new ThreadB().start();
        ThreadC threadC = new ThreadC();
        threadC.start();
        threadC.join();
        System.out.println("FFFFFFFFFFF");

    }

}
