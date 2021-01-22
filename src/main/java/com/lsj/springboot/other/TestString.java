package com.lsj.springboot.other;

import java.lang.reflect.Field;

/**
 * Created by 10326 on 2019/4/9.
 * 通过反射得到String的value属性，改变value数组指向的值，来实现String对象可变。
 * 不建议这么使用，违反了 Java 对 String 类的不可变设计原则，会造成一些安全问题。
 */
public class TestString {

    public static void main(String[] args){
        /*// 0的ascll码：48； A的ascll码：65；a的ascll码是97
        int a = '1';
        System.out.println(a);


        String str = "+86-12331654321";
        str = str.substring(str.indexOf("-") + 1);
        System.out.println(str);*/

        String str = "Hello Python";
        System.out.println(str); // Hello Python

        Field field = null;
        try {
            field = String.class.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);

        char[] value = new char[0];
        try {
            value = (char[])field.get(str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        value[6] = 'J';
        value[7] = 'a';
        value[8] = 'v';
        value[9] = 'a';
        value[10] = '!';
        value[11] = '!';
        System.out.println(str); // Hello Java!!
    }

    /**
     * 编译器进行连接
     */
    public void testString(){
        String str = "Hello"+"World";
    }

    public void testString1(){
        String str = "Hello"+8+"World";
    }
}
