package com.pengcheng.generictest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcliu on 16-10-25.
 */
public class Generic1<T> {

    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public static <E> void out(E t) {
        System.out.println(t);
    }

    public static void print(List<? extends Number> list) {
        System.out.println(list);
    }

    /**
     * http://blog.csdn.net/orzlzro/article/details/7017435
     *
     */
    public static void testGenericArray() {
        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.
        Integer s = (Integer) lsa[1].get(0); // Run time error, but cast is explicit.
        System.out.println(s);
    }

    public static void testGenericArray2() {
        List<String>[] lsa = new ArrayList[10]; // Not really allowed.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Unsound, but passes run time store check
        Object s = (Object) (lsa[1].get(0)); // Run-time error: ClassCastException.
        System.out.println(s);
    }

    public static void main(String[] args) {
        out(11);
        out("asdasd");
        out(null);
        List<Integer> numberList = Lists.newArrayList();
        numberList.add(100);
        numberList.add(20);
        numberList.add(0);
        print(numberList);

        List<?> unknownList2 = Lists.newArrayList();
        testGenericArray();
        testGenericArray2();

    }

}
