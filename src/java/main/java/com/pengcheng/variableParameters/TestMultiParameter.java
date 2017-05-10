package com.pengcheng.variableParameters;

/**
 * Created by pcliu on 16-10-25.
 */
public class TestMultiParameter {

    public static void print(int... nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void print(int a, int... nums) {

    }

    public static void main(String[] args) {
        print();
        print(new int[] {1, 2, 3, 4, 5});
        print(1, new int[]{2, 3, 4, 5});
    }
}
