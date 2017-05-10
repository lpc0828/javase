package com.pengcheng.waitnotifytest;

/**
 * @version 16-12-22 下午4:55.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class TestRunable implements Runnable {
    private String name;
    private Object self;
    private Object prev;

    public TestRunable(String name, Object self, Object prev){
        this.name = name;
        this.self = self;
        this.prev = prev;
    }

    @Override
    public void run() {
        int count = 10;
        while (count-- > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        TestRunable pa = new TestRunable("A", a, c);
        TestRunable pb = new TestRunable("B", b, a);
        TestRunable pc = new TestRunable("C", c, b);

        Thread ta = new Thread(pa);
        Thread tb = new Thread(pb);
        Thread tc = new Thread(pc);
        ta.start();
        Thread.sleep(100);
        tb.start();
        Thread.sleep(100);
        tc.start();
    }
}
