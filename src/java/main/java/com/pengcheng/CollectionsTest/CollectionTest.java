package com.pengcheng.CollectionsTest;


import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by pcliu on 16-9-22.
 */
public class CollectionTest {

    public static void main(String[] args) {

        testContains();
    }

    /**
     * 测试结论： 判断是不是相同的对象，看 hashCode && equals
     */
    public static void testContains() {
        Set<ContainTest> sets = Sets.newHashSet();

        ContainTest t = new ContainTest(100);
        for (int i=0; i<30; i++) {
            sets.add(new ContainTest(i));
        }
        System.out.println("TestContains Begin >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for(ContainTest test : sets) {
            System.out.println(test.getValue());
        }
        System.out.println("TestContains Begin <<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
