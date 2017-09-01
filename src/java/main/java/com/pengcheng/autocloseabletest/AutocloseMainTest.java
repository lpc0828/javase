package com.pengcheng.autocloseabletest;

/**
 * Created by pc.liu on 2017/5/12.
 */
public class AutocloseMainTest {

    public static void main(String[] args) {
        try (HandlerResource hr = new HandlerResource()) {

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("test end<<<<<<<<<<");
    }
}
