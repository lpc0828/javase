package pengcheng.timer;

public abstract class TimeTask implements Runnable {

    static final Object lock = new Object();

    public abstract void run();
}
