package com.pengcheng.multithreadtest.jdkmulti;

import java.util.List;

/**
 * Created by pcliu on 16-10-26.
 */
public class Consumer implements Runnable {

    private List<Task> buffer;

    public Consumer(List<Task> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while(true) {
            synchronized(buffer) {
                while(buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Task task = buffer.remove(0);
                buffer.notifyAll();
                System.out.println("Consumer[" + Thread.currentThread().getName() + "] got " + task);
            }
        }
    }
}
