package com.pengcheng.multithread;

import java.util.Random;

/**
 * Created by pcliu on 16-12-7.
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        Thread3 t1 = new Thread3("C");
        Thread3 t2 = new Thread3("D");
        //Thread1 t3 = t1;

        new Thread(t1).start();
        new Thread(t2).start();
    }
}


class Thread3 implements Runnable {

    private String name;

    public Thread3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                int milSeconds = new Random().nextInt(50) * 10;
                Thread.sleep(milSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}