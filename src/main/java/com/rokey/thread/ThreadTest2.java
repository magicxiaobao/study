package com.rokey.thread;

import java.util.concurrent.CountDownLatch;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author chenyuejun
 * @create 2017-08-28 上午9:58.
 */
public class ThreadTest2 {


    private int count = 1;

    private long millisUnit = 1000;

    public long preserveOrderViaCountDownLatch() {

        long startMills = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(millisUnit);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }, "countDownLatch" + i).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis()-startMills;
    }

    @Test
    public void testPreserveOrderViaCountDownLatch(){

        Assert.assertEquals(1,preserveOrderViaCountDownLatch()/millisUnit);

    }



}
