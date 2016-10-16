package com.pengcheng.testlearn.stringtest;

/**
 * Created by Administrator on 2016/7/10.
 */
public class MyString {

    public static void changeValue(String name) {
        name = new String("11111");
    }

    public static void main(String[] args) {
        String aa = new String("aaaa");
        MyString.changeValue(aa);
        System.out.println(aa);

        String a="111";
        String b="111";
        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        a="222";
        b=new String("222");
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        a="333";
        b=new String("333").intern();
        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        a=new String("444").intern();
        b="444".intern();
        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        a=new String("666");
        b="666".intern();
        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        a="hello word";
        b=new String("hello").intern();
        System.out.println("hello".intern()==b);
        System.out.println("hello".intern().equals(b));

        System.out.println(100+200+"");

    }
}
