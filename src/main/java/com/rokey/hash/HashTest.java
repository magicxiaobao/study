package com.rokey.hash;

import java.util.HashSet;

/**
 * @author chenyuejun
 * @create 2017-08-26 上午11:11.
 * 将对象放到散列容器时，需要复写 hashCode 和equals 方法，因为这个跟散列容器里的具体实现有关
 */
public class HashTest {


    public static void main(String[] args) {


        HashSet<Demo> set = new HashSet<Demo>();

        for(int i=0;i<3;i++){
            set.add(new Demo(i,String.valueOf(i)));
        }
        System.out.println(set);
        set.add(new Demo(1,"1"));
        System.out.println(set);
        System.out.println(set.add(new Demo(0,"0")));
        System.out.println(set.add(new Demo(1,"1")));
        System.out.println(set.add(new Demo(4,"4")));
        System.out.println(set.add(new Demo(4,"55")));
        System.out.println(set);


    }







    private static class Demo{

        private int id;

        private String name;

        public Demo(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Demo demo = (Demo) o;
            return name != null ? name.equals(demo.name) : demo.name == null;
        }

        @Override
        public int hashCode() {
            return id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
