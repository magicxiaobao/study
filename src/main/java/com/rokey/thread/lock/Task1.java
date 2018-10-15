package com.rokey.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyuejun
 * @create 2017-08-27 下午3:57.
 */
public class Task1 implements Runnable {

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private  ReentrantLock lock;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    private AtomicInteger atomicInteger;

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {

        for(int i=0;i<10;){

            lock.lock();
            if(atomicInteger.get()%3==index){
                System.out.println(Thread.currentThread().getName()+"==="+str);
                 atomicInteger.incrementAndGet();
                i++;
            }
            lock.unlock();
        }

    }
}
