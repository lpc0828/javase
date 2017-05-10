package com.pengcheng.lazytest;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by pcliu on 16-12-7.
 */
public class MainTest {

    public static void main(String[] args) {

        List<String> names = Lists.newArrayList();
        names.add("shuai");
        names.add("roy");
        names.add("rocway");
        names.add("rain");

        names.stream().sorted((o1, o2)->o1.compareTo(o2)).distinct();

        System.out.println("sdasdasdasd");

        System.out.println(names);
    }
}
