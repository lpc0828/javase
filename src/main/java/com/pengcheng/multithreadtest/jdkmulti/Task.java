package com.pengcheng.multithreadtest.jdkmulti;

import java.util.UUID;

/**
 * Created by pcliu on 16-10-26.
 */
public class Task {

    private String id;  // 任务的编号

    public Task() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Task[" + id + "]";
    }
}
