package com.pengcheng.jdk8;

/**
 * Created by pcliu on 16-12-6.
 */
public class InterfaceTest {

    public static void main(String[] args) {
        System.out.println(MyInterface.name);
        MyInterface i = new MyImpl1();
        i.doSomething();
        i.printHaha();
        i.call();

        i = new MyImpl2();
        i.doSomething();
        i.printHaha();
        i.call();
    }
}

/**
 * Java8中，接口声明里可以有方法实现了，叫做默认方法。在此之前，接口里的方法全部是抽象方法。
 *
 * 这么做的原因是：
 *  由于Collection库需要为批处理操作添加新的方法，如forEach()，stream()等，
 *  但是不能修改现有的Collection接口——如果那样做的话所有的实现类都要进行修改，
 *  包括很多客户自制的实现类。所以只好使用这种妥协的办法。
 *
 * 这实际上混淆了接口和抽象类，但一个类仍然可以实现多个接口，而只能继承一个抽象类。
 * public class Sub implements Base1, Base2 {
 *     public void hello() {
 *         Base1.super.hello(); //使用Base1的实现
 *     }
 * }
 */
interface MyInterface {
    String name = "MyInterface";

    void doSomething();

    default void printHaha() {
        System.out.println("MyInterface print");
    }

    default void call() {
        printHaha();
    }

    static void abc() {
        System.out.println("MyInterface call abc");
    }
}

class MyImpl1 implements MyInterface {

    @Override
    public void doSomething() {
        System.out.println("MyImpl1 doSomething");
    }

    @Override
    public void printHaha() {
        System.out.println("MyImpl1 print");
    }
}

class MyImpl2 implements MyInterface {

    @Override
    public void doSomething() {
        System.out.println("MyImpl2 doSomething");
    }
}
