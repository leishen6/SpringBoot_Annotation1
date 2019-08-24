package com.lyl.demo2.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IDEA
 * Description：
 * Date: 2019-08-13 19:19
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface MyLog {
    String value() default "日志注解";
}
