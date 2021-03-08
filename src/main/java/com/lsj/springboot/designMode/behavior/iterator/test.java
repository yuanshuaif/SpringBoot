package com.lsj.springboot.designMode.behavior.iterator;

/**
 * Created by 10326 on 2019/10/11.
 * 迭代器设计模式
 * 迭代器模式（Iterator Pattern）是一种非常常用的设计模式，这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 * 阉割版的Iterator
 */
public class test {

    public static void main(String[] args){
        List list = new ArrayList();

        System.out.println(list.add("123"));
        System.out.println(list.add("234"));
        System.out.println(list.add("345"));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println(next);
            if ("234".equals(next))
                iterator.remove();
        }

        System.out.println(list.size());
    }

}
