package com.pengcheng.classes;

/**
 * @version 17-5-9 下午5:07.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class Child extends Parent {

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Child{");
        sb.append("desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
