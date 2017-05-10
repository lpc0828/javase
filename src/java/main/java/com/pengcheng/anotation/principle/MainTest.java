package com.pengcheng.anotation.principle;

/**
 * @version 17-5-8 下午7:13.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
@AnotationPrinciple(say = " what a fuck")
public class MainTest {

    public static void main(String[] args) {
        AnotationPrinciple a = MainTest.class.getAnnotation(AnotationPrinciple.class);
        System.out.println(a.say());
    }


}
