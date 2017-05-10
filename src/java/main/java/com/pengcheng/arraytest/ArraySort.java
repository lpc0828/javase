package com.pengcheng.arraytest;

/**
 * 数组各种排序测试（实现）
 * Created by pcliu on 16-9-18.
 */
public class ArraySort {

    /**
     * 传统的冒泡排序: 某个循环内不再有交换，就说明已经完成排序
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            boolean exchangeFlag = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    exchangeFlag = true;
                }
            }
            if (!exchangeFlag) {
                break;
            }
        }
        return;
    }


    /**
     * 插入排序—直接插入排序(Straight Insertion Sort)
     * 基本思想:
     * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
     * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     * 要点：设立哨兵，作为临时存储和判断数组边界之用。
     *
     * @param a
     */
    public static void insertionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                int j = i;
                while (j > 0 && a[j - 1] > temp) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = temp;
            }
        }
    }


    /**
     * http://www.cnblogs.com/kkun/archive/2011/11/23/2260288.html
     * 插入排序—希尔排序（Shell`s Sort）
     * 希尔排序又叫缩小增量排序
     * 基本思想：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * 操作方法：
     * <p>
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * @param a
     */
    public static void shellSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int group = a.length / 2; group > 0; group = group / 2) {
            for (int i = group; i < a.length; i++) {
                for (int j = i - group; j >= 0; j = j - group) {
                    System.out.println("group==" + group + ", i==" + i + ", j==" + j + ", j+group=" + (j + group));
                    if (a[j] > a[j + group]) {
                        int temp = a[j];
                        a[j] = a[j + group];
                        a[j + group] = temp;
                    }
                }
                System.out.println("--------------------------------------------------------------");
            }
            System.out.println("================================================================");
        }
    }


    /**
     * 选择排序—简单选择排序（Simple Selection Sort）
     * 基本思想：
     * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；
     * 然后在剩下的数当中再找最小（或者最大）的与第2个位置的数交换，
     * 依次类推，
     * 直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
     *
     * @param a
     */
    public static void simplSelectSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i + 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        return;
    }


    /**
     * http://blog.csdn.net/morewindows/article/details/6684558
     * 对挖坑填数进行总结
     * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
     * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     * @param a
     * @param left
     * @param right
     */
    public static void quickSort(int[] a, int left, int right) {
        if (a == null || a.length <= 1) {
            return;
        }
        if (left < right) {
            int pivotKey = a[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && a[high] >= pivotKey) {
                    high--;
                }
                if (low < high) {
                    a[low] = a[high]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
                    low++;
                }
                while (low < high && a[low] <= pivotKey) {
                    low++;
                }
                if (low < high) {
                    a[high] = a[low]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
                    high--;
                }
            }
            a[low] = pivotKey;
            printArray(a);
            System.out.println("基数：" + pivotKey + "， Low:"+low + ", high:"+high);
            quickSort(a, left, low - 1);
            quickSort(a, low + 1, right);
        }
    }


    public static void printArray(int[] a) {
        if (a == null) {
            System.out.println("");
            return;
        }
        if (a.length == 0) {
            System.out.println("[]");
        }
        StringBuilder str = new StringBuilder("[");
        for (int value : a) {
            str.append(value).append(", ");
        }
        str = new StringBuilder(str.substring(0, str.lastIndexOf(", ")));
        str.append("]");
        System.out.println(str.toString());
        return;
    }


    public static void main(String[] args) {
        int[] a = new int[]{-2, 0, 4, 2, 5, 1};
        printArray(a);

//        System.out.println("BubbleSort begin >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        bubbleSort(a);
//        printArray(a);
//        System.out.println("BubbleSort end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//        System.out.println("InsertionSort begin >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        insertionSort(a);
//        printArray(a);
//        System.out.println("InsertionSort end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//        System.out.println("shellSort begin >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        shellSort(a);
//        printArray(a);
//        System.out.println("shellSort end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


//        System.out.println("simplSelectSort begin >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        simplSelectSort(a);
//        printArray(a);
//        System.out.println("simplSelectSort end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


        System.out.println("quickSort begin >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        quickSort(a, 0, a.length - 1);
        printArray(a);
        System.out.println("quickSort end <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
