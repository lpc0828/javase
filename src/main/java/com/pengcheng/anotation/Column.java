package com.pengcheng.anotation;

import java.lang.annotation.*;

/**
 * Created by pcliu on 16-11-16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {

    boolean isPrimaryKey() default false;

    String name() default "";

    String sequenceName() default "";

    boolean isMapping() default true;
}
