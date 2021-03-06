package com.rokey.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyuejun
 * @create 2017-08-29 下午11:00.
 */
public class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker(CountDownLatch countDownLatch) {

        super("DatabaseHealthChecker", countDownLatch);
    }

    @Override
    public void verifyService() {

        System.out.println(this.getServiceName()+" beginning to check!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+" status is up!");

    }
}
