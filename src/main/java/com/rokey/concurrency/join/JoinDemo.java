package com.rokey.concurrency.join;

/**
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
 t.join();      //使调用线程 t 在此之前执行完毕。
 t.join(1000);  //等待 t 线程，等待时间是1000毫秒
 * @author chenyuejun
 * @create 2017-08-27 下午10:51.
 */
public class JoinDemo {


    private static int a = 0;


    static class ThreadJoin extends Thread {
        @Override
        public void run() {

            for (int i = 0; i < 10000; i++) {
                a++;
            }

        }
    }

    public static void main(String[] args) {

        ThreadJoin join = new ThreadJoin();
        join.start();

        /*for(int i=0,j=0;i<150;i++){
            j+=i;
        }*/

        try {
            join.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);

    }


}
