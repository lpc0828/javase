package com.pengcheng.lambdatest;


import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * Created by pc.liu on 2017/8/29.
 */
public class TestFunctionalInterface {

    public static void main(String[] args) {

        TestFunctionalInterface.deploy("asdasdasd", TestFunctionalInterface::doSomething);

        TestFunctionalInterface.deploy("hahah", (str) -> {
            System.out.println(str);
        } );


        Comparator<Integer> c = (s1, s2) -> s1.compareTo(s2);
        System.out.println(c.compare(2, 4));

        Runnable a =TestFunctionalInterface.toDoLater();
        System.out.println("===============================");
        new Thread(TestFunctionalInterface.toDoLater()).start();

//        int sum = 0;
        List<Integer> list = Lists.newArrayList(1, 2, 3);
//        list.forEach(e -> { sum += e; });

        List<Integer> t = Lists.newArrayList();
        list.forEach(e -> { t.add(e); });


    }


    public static void deploy(String someThing, MyInterface myInterface) {
        myInterface.function1(someThing);
    }

    public static String doSomething(String aaa) {
        System.out.println("就是想输出一句话:" + aaa);
        return aaa;
    }

    public static Runnable toDoLater() {
        return () -> {
            System.out.println("later");
        };
    }

}


@FunctionalInterface
interface MyInterface {
    void function1(String aaa);
}