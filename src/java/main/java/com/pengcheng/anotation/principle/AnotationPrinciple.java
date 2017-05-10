package com.pengcheng.anotation.principle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 17-5-8 下午7:10.
 * @Author <a href="mailto:rockway0828@gmail.com">pcliu</a>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotationPrinciple {

    String say() default "Hi miao";

}
