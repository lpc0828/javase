package com.pengcheng.CollectionsTest;

/**
 * Created by pcliu on 16-9-23.
 */
public class ContainTest {

    private int value;

    public ContainTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return value%10;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContainTest{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
