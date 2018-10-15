package com.rokey.java8.lambda;

import java.util.stream.Stream;

/**
 * @author chenyuejun
 * @create 2017-11-01 上午11:49.
 */
public class LambdaReduce {

    public static void main(String[] args) {
        // 相当于foreach遍历操作结果值
        Integer out = Stream.of(10, 5, 3, 2, 1, 0).reduce((result, item) -> {
            if (item >= 3) {
                result = result + item;
            }
            return result;
        }).get();
        System.out.println(out);

        // 相当于给定初始结果值，foreach遍历操作结果值
        Integer sum = Stream.of(10, 5, 3, 2, 1, 0).reduce(9, LambdaReduce::sumTest);
        System.out.println(sum);

        //相当于给定初始结果值，两个foreach遍历操作结果值
        int str = Stream.of(1,2,3).parallel().reduce(1, (result, item) -> {
            return result + item;
        } , (result, item) -> {
            //注：只有并行parallel下才会进入此方法
            return result + item ;
        });
        System.out.println(str);
    }

    //替换Integer::sum测试
    public static Integer sumTest(int a1, int a2) {
        return a1 + a2;
    }

}
