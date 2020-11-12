package com.ioc.spring;

public class Readme {
    /**
     * 1.annoation:定义常用的两个依赖注解,一个是标致service的,一个是service的属性依赖,看具体代码
     * 2.service:定义两个简单演示的service,并且增加对应的注解
     * 3.util:定义一个工具类主要扫描某个包路径下面的所有class
     * 4.context:定义模拟spring的上下文,初始化bean对象和对应的属性对象
     *
     * 1 首先需要实现类似于spring的componetscan:自动包扫描
     * 2 找到该包下面哪些类是加了对应的注解
     * 3 找到这些加了注解的类,进行模拟spring初始化功能,beanid和bean实例化功能
     * 4 对应的依赖属性初始化:主要通过反射+已经实例化好的bean集合
     * 注意:上面的代码只是帮助我们更好的理解IOC机制,但和原始的spring的IOC相比是不可相提并论的,建议大家还是去看看spring源码.
     */
}
