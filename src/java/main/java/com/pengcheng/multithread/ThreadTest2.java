package com.pengcheng.multithread;

import java.util.Random;

/**
 * Created by pcliu on 16-12-7.
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("A");
        Thread1 t2 = new Thread1("B");
        //Thread1 t3 = t1;

        t1.start();
        t2.start();
        //t3.start();
    }
}

class Thread1 extends Thread {

    private String name;
    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                int milSeconds = new Random().nextInt(50) * 10;
                sleep(milSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
