package com.pengcheng.testInheritance;


/**
 * Created by pcliu on 16-10-25.
 */
public class InheritanceInt {

    static final int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        int a = n >>> 1;
        n |= a;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        InheritanceInt.tableSizeFor(10);
        System.out.println(hashValue("az"));
    }

    static int hashValue(Object key) {
        int h;
        if (key == null) {
            return 0;
        }
        h = key.hashCode();
        return h^(h >> 16);
    }
}
