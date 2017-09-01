package com.pengcheng.lambdatest;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by pc.liu on 2017/8/30.
 */
public class TestParalle {

    public static List<Integer> createList(int size) {
        List<Integer> list = Lists.newArrayList();
        for (int i=1; i<=size; i++) {
            list.add(i);
        }

        return list;
    }

    public static int traditionalSum(List<Integer> data) {
        int sum = 0;
        for (Integer i : data) {
            sum += i;
        }

        return sum;
    }


    public static int paralleSum(List<Integer> data) {
        int sum = data.parallelStream().mapToInt(e->e.intValue()).sum();
        return sum;
    }

    public static void main(String[] args) {
        long time1= System.currentTimeMillis();
        List<Integer> data = createList(10000000);
        long time2 = System.currentTimeMillis();
        System.out.println("createList cost:" + (time2-time1));

        int sum = traditionalSum(data);
        long time3 = System.currentTimeMillis();
        System.out.println("traditionalSum cost:" + (time3-time2) + ", and sum="+sum);

        sum = paralleSum(data);
        long time4 = System.currentTimeMillis();

        System.out.println("paralleSum cost:" + (time4-time3) + ", and sum="+sum);
    }
}
