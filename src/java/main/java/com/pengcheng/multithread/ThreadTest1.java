package com.pengcheng.multithread;

/**
 * Created by IntelliJ IDEA.
 *
 * @version V1.0.0
 * @author: <a href="mailto:pengcheng.liu0828@gmail.com">pc.liu</a>.
 * @since: 2016/12/6.
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
    }
}

class MyThread1 implements Runnable {

    private static native void registerNatives();
    static {
        registerNatives();
    }

    public void run() {
        System.out.println(" execute MyThread1");
    }

    private native void start0();

    public void start() {
        start0();
    }
}
