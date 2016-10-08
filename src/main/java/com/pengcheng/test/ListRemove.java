package com.pengcheng.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by pcliu on 16-8-13.
 */
public class ListRemove {

    private List<TestObject> testObjectList;

    public List<TestObject> getTestObjectList() {
        return testObjectList;
    }

    public void setTestObjectList(List<TestObject> testObjectList) {
        this.testObjectList = testObjectList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListRemove{");
        sb.append("testObjectList=").append(testObjectList);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {

        ListRemove listRemove = new ListRemove();

        TestObject o1 = new TestObject();
        TestObject o2 = new TestObject();
        TestObject o3 = new TestObject();
        TestObject o4 = new TestObject();
        TestObject o5 = new TestObject();

        o1.setName("001");
        o2.setName("002");
        o3.setName("003");
        o4.setName("004");
        o5.setName("005");

        List<TestObject> list = new ArrayList<TestObject>();
        list.add(o1);
        list.add(o2);
        list.add(o3);
        list.add(o4);
        list.add(o5);

        listRemove.setTestObjectList(list);

        System.out.println(listRemove.toString());
//        for (TestObject object : listRemove.getTestObjectList()) {
//            if (StringUtils.equals("002", object.getName()) || StringUtils.equals("004", object.getName())) {
//                System.out.println("removing......");
//                listRemove.getTestObjectList().remove(object);
//            }
//        }
        for (Iterator it = listRemove.getTestObjectList().iterator(); it.hasNext();) {
            TestObject object = (TestObject) it.next();
            if (StringUtils.equals("002", object.getName()) || StringUtils.equals("004", object.getName())) {
                  System.out.println("removing......");
                listRemove.getTestObjectList().remove(object);
            }
        }
        System.out.println(listRemove.toString());
    }

}

class TestObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestObject{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
