package com.pengcheng.anotation;

import java.lang.annotation.*;

/**
 * Created by pcliu on 16-11-16.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    String name() default "";
}
