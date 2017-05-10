package com.pengcheng.anotation.principle;

/**
 * @version 17-5-8 下午7:23.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
@AnotationPrinciple(say = " what a fuck")
public class MainTest2 {

    /**
     * Java注解（Annotation）原理详解
     * http://blog.csdn.net/lylwo317/article/details/52163304
     * @param args
     */
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        AnotationPrinciple a = MainTest.class.getAnnotation(AnotationPrinciple.class);
        System.out.println(a.toString());
    }
}
