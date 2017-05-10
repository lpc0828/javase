package com.pengcheng.synchronizedtest;

/**
 * @version 16-12-21 下午6:19.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SyncClass {

    private Integer counter = new Integer(0);

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void excute1() {
        synchronized (counter) {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" excute1 seq:" + i);
            }
        }
    }

    public void excute2() {
        synchronized (counter) {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " excute2 seq:" + i);
            }
        }
    }

}
