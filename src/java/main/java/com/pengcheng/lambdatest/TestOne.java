package com.pengcheng.lambdatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pcliu on 16-12-6.
 */
public class TestOne {


    /**
     * 测试集合的Lambda 操作方式
     */
    public static void demo1() {
        List<String> names = new ArrayList<>();
        names.add("One");
        names.add("Two");
        names.add("Three");
        names.add("Four");
        names.add("Five");
        names.add("Six");
        names.add("Seven");
        names.add("Eight");
        names.add("Nine");
        names.add("Ten");

        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
        System.out.println(names);

        System.out.println(names.stream().map((String name)->{return name.toLowerCase();}).collect(Collectors.toList()));

        names.forEach(System.out::println);
        names.forEach(e-> System.out.print(e+" "));
    }


    public static void demo2() {
        Runnable r = ()-> System.out.println(" 执行一个任务");
        r.run();
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }

}
