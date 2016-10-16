package com.pengcheng.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.io.IOException;

/**
 * Created by pcliu on 16-8-10.
 */
public class DeepCloneTest {

    public static String className = "DeepCloneJson";
    private transient String specName;
    private int age;
    private CloneObject cloneObject;

    public CloneObject getCloneObject() {
        return cloneObject;
    }

    public void setCloneObject(CloneObject cloneObject) {
        this.cloneObject = cloneObject;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        DeepCloneTest.className = className;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeepCloneTest{");
        sb.append("specName='").append(specName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


    public void DeepCloneJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String str = mapper.writeValueAsString(this);
            DeepCloneTest deepCloneJson1 = mapper.readValue(str, DeepCloneTest.class);
            System.out.println(this.getAge() + "============" + deepCloneJson1.getAge());
            System.out.println(this.getSpecName() + "============" + deepCloneJson1.getSpecName());
            deepCloneJson1.setAge(11);
            deepCloneJson1.setSpecName("12312312");
            System.out.println(this.getAge() + "============" + deepCloneJson1.getAge());
            System.out.println(this.getSpecName() + "============" + deepCloneJson1.getSpecName());
        } catch (JsonProcessingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DeepCloneTest deepCloneJson = new DeepCloneTest();
        deepCloneJson.setAge(10);
        deepCloneJson.setSpecName("aaaa");
        CloneObject cloneObject = new CloneObject();
        cloneObject.setName("bbbb");
        cloneObject.setProperties(Lists.newArrayList("111"));

    }

}
