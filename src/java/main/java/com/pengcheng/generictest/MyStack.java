package com.pengcheng.generictest;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 自己实现的Stack数据结构，实现后进先出的堆栈逻辑
 * Created by pc.liu on 2017/5/15.
 */
public class MyStack<E> {

    private int size;
    private int Default_Capacity_Size = 16;
    private E[] elements;

    public MyStack() {
        elements = (E[]) new Object[Default_Capacity_Size];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2*size+1);
        }
    }


}
