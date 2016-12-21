package com.pengcheng.synchronizedtest;

/**
 * @version 16-12-21 下午6:19.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SyncClass {

    private static int counter = 0;

    public synchronized void excute1() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("excute1 seq:" + i);
        }
    }

    public synchronized void excute2() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("excute2 seq:" + i);
        }
    }

}
