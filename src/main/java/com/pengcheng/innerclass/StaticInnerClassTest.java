package com.pengcheng.innerclass;



/**
 * Created by pcliu on 16-11-29.
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        StaticInner.Inner inner = new StaticInner.Inner();
        inner.method();
    }
}

class StaticInner{

    private int a = 4;
    private static int b = 5;

    static class Inner {
        private int b = 6;
        public void method() {
            System.out.println(b);
            System.out.println(StaticInner.b);
        }
    }
}
