package com.pengcheng.test;

import java.lang.reflect.Field;

/**
 * Created by pcliu on 16-9-20.
 */
public class StringSwap {

    private static void swap(String a, String b) {
        try {
            char[] temp = a.toCharArray();
            Field fieldA = a.getClass().getDeclaredField("value");
            fieldA.setAccessible(true);
            fieldA.set(a, b.toCharArray());
            fieldA.setAccessible(false);

            Field fieldB = b.getClass().getDeclaredField("value");
            fieldB.setAccessible(true);
            fieldB.set(b, temp);
            fieldB.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String strA = "aaaaaa";
        String strB = "bbbbbb";
        System.out.println("before>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("strA == " + strA);
        System.out.println("strB == " + strB);

        swap(strA, strB);
        System.out.println("after<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("strA == " + strA);
        System.out.println("strB == " + strB);
    }
}
