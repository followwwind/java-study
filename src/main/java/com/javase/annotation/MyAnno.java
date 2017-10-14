package com.javase.annotation;

import java.lang.annotation.*;


/**
 * @author wind
 */
@Documented
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

    String value() default "";

}
