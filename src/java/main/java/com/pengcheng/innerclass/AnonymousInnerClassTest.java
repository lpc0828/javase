package com.pengcheng.innerclass;

/**
 * 匿名内部类，适用于 只使用一次，
 * 不需要重复利用的实现子类。
 * Created by pcliu on 16-11-29.
 */
public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous() {
            @Override
            public void method2() {
                System.out.println("AnonymousClass method2");
            }
        };
        anonymous.method1();
        anonymous.method2();
    }
}


abstract class Anonymous {

    public void method1() {
        System.out.println("AnonymousClass method1");
    }

    public abstract void method2();
}