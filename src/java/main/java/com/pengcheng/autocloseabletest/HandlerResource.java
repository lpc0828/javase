package com.pengcheng.autocloseabletest;

/**
 * Created by pc.liu on 2017/5/12.
 */
public class HandlerResource implements AutoCloseable {



    @Override
    public void close() throws Exception {
        System.out.println(" HandlerResource autoclose！");
    }
}
