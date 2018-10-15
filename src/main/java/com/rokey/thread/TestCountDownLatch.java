package com.rokey.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyuejun
 * @create 2017-08-29 下午11:05.
 */
public class TestCountDownLatch {


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        List<BaseHealthChecker> checkers = new ArrayList<BaseHealthChecker>(3);
        checkers.add(new NetWorkHealthChecker(latch));
        checkers.add(new DatabaseHealthChecker(latch));
        checkers.add(new CacheHealthChecker(latch));
        ExecutorService service = Executors.newFixedThreadPool(checkers.size());
        for(BaseHealthChecker v :checkers){
            service.execute(v);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //print check status
        for(BaseHealthChecker v:checkers){
            System.out.println(v.getServiceName()+"status up is "+v.isServiceUp());
        }


    }





}
