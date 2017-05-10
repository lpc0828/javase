package com.pengcheng.collections.listtest;

import java.io.Serializable;
import java.sql.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by pcliu on 16-10-10.
 */
public class MyArrayList<T> extends AbstractList<T> implements List<T>, RandomAccess, Serializable, Cloneable{

    // 序列版本号
    private static final long serialVersionUID = 8683452581122892189L;

    // ArrayList基于该数组实现，用该数组保存数据
    private transient Object[] elementData;

    // ArrayList中实际数据的数量
    private int size;

    private int modCount;

    // ArrayList带容量大小的构造函数
    public MyArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal Capacity:"+initialCapacity);
        }
        // 新建初始化数组
        this.elementData = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(0);
    }


    public MyArrayList(Collection<? extends T> c) {
        elementData = c.toArray();
        size = elementData.length;
        if (elementData.getClass() != Object[].class) {
            elementData = Arrays.copyOf(elementData, size, Object[].class);
        }
    }

    // 将当前容量值设为实际元素个数
    public void trimToSize() {
        modCount++;
        int oldCapacity = elementData.length;
        if (size < oldCapacity) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }

    // 确定ArrarList的容量。
    // 若ArrayList的容量不足以容纳当前的全部元素，设置 新的容量=“(原始容量x3)/2 + 1”
    public void ensureCapacity(int minCapacity) {
        // 将“修改统计数”+1，该变量主要是用来实现fail-fast机制的
        modCount++;
        int oldCapacity = elementData.length;
        if (minCapacity < oldCapacity) {
            int newCapacity = (oldCapacity*3)/2+1;
            //如果还不够，则直接将minCapacity设置为当前容量
            if (minCapacity > newCapacity) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    // 添加元素e
    public boolean add(T e) {
        // 确定ArrayList的容量大小
        ensureCapacity(size + 1);  // Increments modCount!!
        // 添加e到ArrayList中
        elementData[size++] = e;
        return true;
    }

    // 返回ArrayList的实际大小
    @Override
    public int size() {
        return size;
    }

    // ArrayList是否包含Object(o)
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    public T get(int index) {
        rangeCheck(index);
        return (T) this.elementData[index];
    }

    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    public <T> T[] toArray(T[] a) {
        // 若数组a的大小 < ArrayList的元素个数；
        // 则新建一个T[]数组，数组大小是“ArrayList的元素个数”，并将“ArrayList”全部拷贝到新数组中
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size);
        }
        // 若数组a的大小 >= ArrayList的元素个数；
        // 则将ArrayList的全部元素都拷贝到数组a中。
        System.arraycopy(elementData, 0, a, 0, size);
        if (size < a.length) {
            a[size] = null;
        }
        return a;
    }

    // 设置index位置的值为element
    public T set(int index, T element) {
        rangeCheck(index);

        T oldValue = (T) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    // 将e添加到ArrayList的指定位置
    public void add(int index, T element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        ensureCapacity(size+1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }


    public void replaceAll(UnaryOperator<T> operator) {

    }

    public void sort(Comparator<? super T> c) {

    }

    public Spliterator<T> spliterator() {
        return null;
    }

    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    public Stream<T> stream() {
        return null;
    }

    public Stream<T> parallelStream() {
        return null;
    }

    public void forEach(Consumer<? super T> action) {

    }
}
