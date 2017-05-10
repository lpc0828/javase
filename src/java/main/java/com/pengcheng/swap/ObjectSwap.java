package com.pengcheng.swap;

/**
 * @version 17-2-10 下午5:00.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class ObjectSwap {

    public static void main(String[] args) {
        TestObject o1 = new TestObject("o1");
        TestObject o2 = new TestObject("o2");

        System.out.println("o1="+o1.toString());
        System.out.println("o2="+o2.toString());
    }

    public static void swap(TestObject o1, TestObject o2) {
        o1 = new TestObject("oa");
        o2 = new TestObject("ob");
    }


}
