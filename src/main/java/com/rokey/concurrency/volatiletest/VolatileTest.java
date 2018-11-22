package com.rokey.concurrency.volatiletest;

import org.junit.Test;

/**
 * 参考 http://ifeve.com/你应该知道的-volatile-关键字/
 * volatile 并不能保证线程并发的安全性，volatile修饰的基本类型变量 不能保证原子性
 *
 * 保证的是内存可见性
 * @author chenyuejun
 * @create 2017-10-20 下午10:58.
 */
public class VolatileTest {

    private volatile boolean flag = false;

    @Test
    public void volatileTest() {

        Thread threadA = new Thread(new Runnable() {

            int i = 0;
            @Override
            public void run() {

                System.out.println("Thread A Start!");
                while (!flag) {

                    System.out.println(i++);
                }
                System.out.println("Thread A Stop!");
            }
        });

        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("Thread B Start!");
                flag = true;
                System.out.println("Thread B Stop!");
            }
        });

        threadA.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }

}
