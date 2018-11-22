package com.rokey.concurrency;

/**
 * @author chenyuejun
 * @create 2017-08-28 上午9:51.
 */
public class ThreadTest1 {


    public static void main(String[] args) {

        Thread thread;
        for(int i=0;i<100;i++){
            final int k =i;
            thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("k="+k);
                }
            },"thread-"+k);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}
