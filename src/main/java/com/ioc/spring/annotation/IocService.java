package com.ioc.spring.annotation;

import java.lang.annotation.*;

/**
 * 自定义服务的依赖注入注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IocService {
    String name() default "";
}
