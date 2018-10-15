package com.rokey.compare;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author chenyuejun
 * @create 2017-08-26 下午12:42.
 */
public class PeachComparator implements Comparator<Peach> {

    @Override
    public int compare(Peach o1, Peach o2) {
        return o1.getWeight()-o2.getWeight();
    }


    public static void main(String[] args) {

        PeachComparator peachComparator = new PeachComparator();
        TreeSet<Peach> peaches = new TreeSet<Peach>(peachComparator);
        peaches.add(new Peach(1,"第一个桃子"));
        peaches.add(new Peach(3,"第二个桃子"));
        peaches.add(new Peach(2,"第三个桃子"));
        Iterator<Peach> peachIterator = peaches.iterator();
        while(peachIterator.hasNext()){
            Peach peach = peachIterator.next();
            System.out.println("wight:"+peach.getWeight()+"name:"+peach.getName());
        }


    }


}
