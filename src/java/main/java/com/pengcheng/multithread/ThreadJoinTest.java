package com.pengcheng.multithread;

/**
 * Created by pcliu on 16-12-9.
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        Thread t = new Thread(new TestRunnable());

        t.start();
        try {
            t.join();
            System.out.println("thread join done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("TestRunnable begin");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestRunnable over");
    }
}
