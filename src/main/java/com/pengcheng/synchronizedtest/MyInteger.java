package com.pengcheng.synchronizedtest;

/**
 * @version 16-12-22 上午10:11.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class MyInteger {

    public MyInteger()  {
    }

    public MyInteger(Integer value) {
        this.value = value;

        String s = "12331414";
        s.substring(4);
        s.substring(4);
        String s1 = new String(s.substring(4));
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
