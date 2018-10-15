package com.rokey.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyuejun
 * @create 2017-08-29 下午10:30.
 */
public abstract class BaseHealthChecker implements Runnable {


    private String serviceName;

    private CountDownLatch countDownLatch;

    private boolean serviceUp;


    public BaseHealthChecker(String serviceName, CountDownLatch countDownLatch) {
        super();
        this.serviceName = serviceName;
        this.countDownLatch = countDownLatch;
        this.serviceUp = false;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    public void setServiceUp(boolean serviceUp) {
        this.serviceUp = serviceUp;
    }

    @Override
    public void run() {

        try {
            verifyService();
            this.setServiceUp(true);
        } catch (Exception e) {
            e.printStackTrace();
            this.setServiceUp(false);
        } finally {
            if(countDownLatch!=null){
                countDownLatch.countDown();
            }
        }

    }

    public abstract void verifyService();

}
