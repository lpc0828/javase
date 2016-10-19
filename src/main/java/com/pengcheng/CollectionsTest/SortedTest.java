package com.pengcheng.CollectionsTest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/10/16.
 */
public class SortedTest {

    public static void testSorted() {
        TreeSet treeSet = new TreeSet<String>(new Comparator() {
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;
                return 0-str1.compareTo(str2);
            }
        });

        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("G");
        treeSet.add("E");
        treeSet.add("D");
        treeSet.add("F");
        for(Iterator iter = treeSet.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }

    }

    public static void main(String[] args) {
        testSorted();
    }
}
