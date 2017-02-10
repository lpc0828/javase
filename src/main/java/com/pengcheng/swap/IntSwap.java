package com.pengcheng.swap;

import java.lang.reflect.Field;

/**
 * @version 17-2-10 下午4:58.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class IntSwap {


    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(20);

        swap(a, b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }


    private static void swapAB(Integer a, Integer b) {
        a= 100;
        b= 200;
    }

    private static void swap(Integer a, Integer b) {
        try {
            Field fieldA = a.getClass().getDeclaredField("value");
            fieldA.setAccessible(true);
            fieldA.set(a, 100);
            fieldA.setAccessible(false);

            Field fieldB = b.getClass().getDeclaredField("value");
            fieldB.setAccessible(true);
            fieldB.set(b, 200);
            fieldB.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
