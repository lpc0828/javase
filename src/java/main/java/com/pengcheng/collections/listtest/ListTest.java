package com.pengcheng.collections.listtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcliu on 16-10-10.
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>(20);
        names.add("aaaaaa");
        names.add("bbbbbb");
        System.out.println(names.size());

        String[] a = new String[4];
        a[0] = "0000";
        a[1] = "1111";
        a[2] = "2222";
        a[3] = "3333";
        for (String arg : a) {
            System.out.println(arg);
        }
        System.out.println("设置数据的某个元素为null,看其后面的数据是不是还能出来。");
        a[1] = null;
        for (String arg : a) {
            System.out.println(arg);
        }
        System.out.println("测试List.toArray(T[] a)");
        a = names.toArray(a);
        for (String arg : a) {
            System.out.println(arg);
        }
    }
}
