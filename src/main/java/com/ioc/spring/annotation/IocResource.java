package com.ioc.spring.annotation;

import java.lang.annotation.*;

/**
 * 自定义属性的依赖注入
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IocResource {
    String name() default "";
}
