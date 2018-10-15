package com.rokey.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenyuejun
 * @create 2017-09-14 上午8:34.
 */
public class LambdaTest {

    static int i = 0;

    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1, 5, 3, 8, 4, 10, 2};
        List<Integer> integerList = Arrays.asList(integers);
        /*integerList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*/
        /*integerList.sort((Integer o1,Integer o2) -> o1.compareTo(o2));

        for(Integer integer : integerList){
            System.out.println(integer);
        }
        */

        String[] strings = new String[]{"a", "A", "daddy", "Teacher", "Developer"};
        List<String> stringList = Arrays.asList(strings);
        stringList.sort(String::compareToIgnoreCase);
        stringList.forEach(System.out::println);

        stringList.sort(Comparator.comparing(String::length));
        stringList.forEach(System.out::println);


        Thread thread = new Thread(() -> {
            i++;
            System.out.println(i);
        });
        thread.start();

        List<Student> students = new ArrayList<Student>();
        Student guoguo = new Student();
        guoguo.setName("guoguo");
        guoguo.setAge(5);
        students.add(guoguo);
        Student suisui = new Student();
        suisui.setName("suisui");
        suisui.setAge(33);
        students.add(suisui);
        System.out.println(students.stream().map(student -> student.getName() + ":" + student.getAge()).reduce((a, b)
                -> a + "," + b).get());
    }


    private static class Student {

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Entity1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
