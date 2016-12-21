package com.pengcheng.synchronizedtest;

/**
 * @version 16-12-21 下午6:21.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class SyncTest {

    public static void main(String[] args) {
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
