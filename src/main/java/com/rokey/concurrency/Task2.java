package com.rokey.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyuejun
 * @create 2017-08-27 下午11:11.
 */
public class Task2 implements Runnable {

    private String str;
    private ReentrantLock lock;
    private int index;
    private AtomicInteger atomicInteger;
    private Condition[] conditions;


    public Condition[] getConditions() {
        return conditions;
    }

    public void setConditions(Condition[] conditions) {
        this.conditions = conditions;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {

        try {
            lock.lock();
            for(int i=0;i<10;i++){
                while(atomicInteger.get()%3!=index){
                        conditions[index].await();
                }
                System.out.println(str);
                atomicInteger.incrementAndGet();
                if(index<(conditions.length-1)){
                    int j= index+1;
                    conditions[j].signal();
                }else {
                    conditions[0].signal();
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
