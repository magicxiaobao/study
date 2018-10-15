package com.rokey.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyuejun
 * @create 2017-08-27 下午11:09.
 */
public class ConditionDemo2 {

    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {

        Condition[] conditions = new Condition[3];
        conditions[0] = conditionA;
        conditions[1] = conditionB;
        conditions[2] = conditionC;
        Task2 taskA = new Task2();
        taskA.setLock(lock);
        taskA.setAtomicInteger(atomicInteger);
        taskA.setConditions(conditions);
        taskA.setIndex(0);
        taskA.setStr("A");
        Task2 taskB = new Task2();
        taskB.setStr("B");
        taskB.setIndex(1);
        taskB.setConditions(conditions);
        taskB.setAtomicInteger(atomicInteger);
        taskB.setLock(lock);
        Task2 taskC = new Task2();
        taskC.setLock(lock);
        taskC.setAtomicInteger(atomicInteger);
        taskC.setConditions(conditions);
        taskC.setIndex(2);
        taskC.setStr("C");
        new Thread(taskA).start();
        new Thread(taskB).start();
        Thread threadC = new Thread(taskC);
        threadC.start();
        try {
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印计数值
        System.out.println("打印计数值"+atomicInteger.get());


    }





}
