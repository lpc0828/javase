package com.pengcheng.innerclass;

/**
 * 成员内部类，
 * 注意:
 * 1. 外部的时候的创建方式 <br/>
 * 2. 注意<code>内部类<code/>和<code>外部类<code/>成员变量名相同时的访问方式区分；<br/>
 *
 * Created by pcliu on 16-11-29.
 */
public class MemberInnerClassTest {

    public static void main(String[] args) {

        MemberInnerClass.Inner inner = (new MemberInnerClass()).new Inner();
        inner.method();
    }
}

class MemberInnerClass {

    private int a = 4;

    class Inner {
        private int a = 6;
        public void method() {
            System.out.println(a);
            System.out.print(MemberInnerClass.this.a);
        }
    }
}