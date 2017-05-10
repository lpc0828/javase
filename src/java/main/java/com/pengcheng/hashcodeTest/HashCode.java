package com.pengcheng.hashcodeTest;

/**
 * @version 17-4-12 下午4:33.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class HashCode {

    public static void main(String[] args) {
        Data a = new Data();
        a.setAge(10);
        a.setGoals(99.5f);
        a.setName("张三");
        System.out.println("a.hashCode="+a.hashCode());

        a.setAge(11);
        System.out.println("a.hashCode="+a.hashCode());

    }
}
