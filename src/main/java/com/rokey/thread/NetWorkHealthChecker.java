package com.rokey.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyuejun
 * @create 2017-08-29 下午10:46.
 */
public class NetWorkHealthChecker extends BaseHealthChecker {


    public NetWorkHealthChecker(CountDownLatch countDownLatch) {
        super("NetworkHealthChecker", countDownLatch);
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
