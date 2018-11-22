package com.rokey.concurrency.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyuejun
 * @create 2017-08-27 下午4:04.
 */
public class LockDemo2 {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger atomicInteger = new AtomicInteger();
        Task1 task1 = new Task1();
        task1.setIndex(0);
        task1.setAtomicInteger(atomicInteger);
        task1.setLock(lock);
        task1.setStr("A");
        Task1 task2 = new Task1();
        task2.setStr("B");
        task2.setAtomicInteger(atomicInteger);
        task2.setLock(lock);
        task2.setIndex(1);
        Task1 task3 = new Task1();
        task3.setIndex(2);
        task3.setLock(lock);
        task3.setAtomicInteger(atomicInteger);
        task3.setStr("C");
        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();

    }


}
