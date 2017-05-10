package com.pengcheng.anotation;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by pcliu on 16-11-16.
 */
public class AnotationTest {

    public static void main(String[] args) {
        TestTable testTable = new TestTable();
        testTable.setId(1000L);
        testTable.setCreatedDate(new Date());
        testTable.setName("test_one");
        testTable.setNickName("东方测试注解处理器");

        Class<?> tableClass = testTable.getClass();
        System.out.println("table name:"+ tableClass.getDeclaredAnnotation(Table.class).name());
        for (Field field : tableClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println("filed name:"+field.getName()+", filed value:" + field.get(testTable));
//                System.out.println("filed name:"+ field.getName()+", anotations:"+ field.getAnnotations());
//                System.out.println("filed name:"+ field.getName()+", declaredAnnotations:"+ field.getDeclaredAnnotations());
                if (field.isAnnotationPresent(Column.class)) {
                    Column colAnotation = field.getDeclaredAnnotation(Column.class);
                    System.out.println("filed name:"+field.getName()+", isPrimaryKey:"+colAnotation.isPrimaryKey()+", name="+colAnotation.name()
                    +", sequenceName="+colAnotation.sequenceName()+", isMapping="+ colAnotation.isMapping());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
