package com.pengcheng.classes;


/**
 * @version 17-5-9 下午5:08.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
public class ClassTest {

    public static void print(Class cls, String value) {
        System.out.println(cls.toString());
    }

    public static void printCheck(Class<? extends Parent> cls, String value) {
        try {
            Parent parent = (Parent) cls.newInstance();
            System.out.println(parent.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.setId(100);
        child.setName("child");
        child.setDesc("孩子");
        ClassTest.print(child.getClass(), "asdasd");
        System.out.println("====================================");
        ClassTest.printCheck(child.getClass(), "asdasdas");
    }
}
