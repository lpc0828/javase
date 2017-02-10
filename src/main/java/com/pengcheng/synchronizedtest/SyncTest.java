package com.pengcheng.synchronizedtest;

/**
 * @version 16-12-21 下午6:21.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SyncTest {

    /**
     * 测试的结论如下：
     *   1. 如果方法是 普通成员函数 和 synchronized(this) 是没有区别的，需要操作同一个对象才会起效果；
     *   2. 如果方法是静态和非静态，则无效果;
     *   3. 静态的对与所有的对象都有效果
     *   4. 如果是 synchronied(Object) 那么，这个Object要区分是静态还是非静态成员变量；如果是静态成员变量，则全局；
     *   否则 要看 该类型 是基本数据类型还是 自定义类型；如 int，String等值相同，地址相同，不同的instances也会被锁住
     * @param args
     */
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
        SyncClass syncClass1 = new SyncClass();
        SyncClass syncClass2 = new SyncClass();

        Thread t1 = new Thread(new TestRunnable1(syncClass1));
        Thread t2 = new Thread(new TestRunnable2(syncClass2));
        t1.start();
        t2.start();
    }

    public static void test1() {
        SyncClass syncClass = new SyncClass();

        Thread t1 = new Thread(new TestRunnable1(syncClass));
        Thread t2 = new Thread(new TestRunnable2(syncClass));
        t1.start();
        t2.start();
    }


}

class TestRunnable1 implements Runnable {

    private SyncClass syncClass;

    public TestRunnable1(SyncClass syncClass) {
        this.syncClass = syncClass;
    }
    @Override
    public void run() {
        this.syncClass.excute1();
    }
}

class TestRunnable2 implements Runnable {
    private SyncClass syncClass;

    public TestRunnable2(SyncClass syncClass) {
        this.syncClass = syncClass;
    }

    @Override
    public void run() {
        this.syncClass.excute2();
    }
}
