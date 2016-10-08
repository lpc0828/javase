package com.pengcheng.test;

import java.util.List;

/**
 * Created by pcliu on 16-8-11.
 */
public class CloneObject {

    private String name;
    private List<String> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CloneObject{");
        sb.append("name='").append(name).append('\'');
        sb.append(", properties=").append(properties);
        sb.append('}');
        return sb.toString();
    }
}
