package com.pengcheng.swap;

/**
 * @version 17-2-10 下午4:59.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class TestObject {

    private String value;

    public TestObject() {

    }

    public TestObject(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestObject{");
        sb.append("value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
