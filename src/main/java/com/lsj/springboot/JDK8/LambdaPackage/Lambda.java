package com.lsj.springboot.JDK8.LambdaPackage;

import com.lsj.springboot.JDK8.SreamPackage.Data;
import com.lsj.springboot.JDK8.SreamPackage.PersonModel;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Created by 10326 on 2019/4/20.
 * 1.lambda表达式本质上就是匿名内部类，也可以是一段可以传递的代码
 * 2.StreamAPI中的lambda表达式
 * ****lambda表达式可以在某种意义上理解为对匿名内部类的简化***
 *
 * 1.函数式接口的提出是为了给Lambda表达式的使用提供更好的支持，不需要自己再手动创建一个函数式接口，直接拿来用就好了。
 * 四大核心函数式接口：
 * Consumer：有参数无返回值
 * Supplier：无参数有返回值
 * Function：有参数有返回值
 * Predicate：有参有返回值，返回值是boolean类型（断言型接口）
 * 还有其他一些
 */
public class Lambda {

    public static void main(String[] args){
        test();
//        test1();
//        test2();
    }

    /**
     * lambda体中的内容有方法已经实现啦，则可以使用方法引用
     * 6.0方法引用、构造器引用
     *
     */
    public static void test(){

        List<PersonModel> list = Data.getData();
        list.forEach(System.out::println);
        //方法引用：Lambda表达式的简化
        // 对象::实例方法   类::静态方法
        // 类::实例方法(若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method)
        Consumer<Integer> con = (x) -> System.out.println(x);
        con.accept(100);
        Consumer<Integer> con1 = System.out::println;
        con1.accept(101);
        // 方法引用-类名::静态方法名
        BiFunction<Integer, Integer, Integer> biFun = (x, y) -> Integer.compare(x, y);
        BiFunction<Integer, Integer, Integer> biFun2 = Integer::compare;
        Integer result = biFun2.apply(100, 200);
        System.out.println(result);
        // 方法引用-类名::实例方法名
        BiFunction<String, String, Boolean> fun1 = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> fun2 = String::equals;
        Boolean result2 = fun2.apply("hello", "world");
        System.out.println(result2);

    }

    /**
     * 1.0 —— 2.0 Lambda表达式
     */
    public static void test1(){

        List<PersonModel> list = Data.getData();
        MyFilter myFilter = new MyFilter();
        /* 1.0 多态形式实现*/
        Filter filter1 = new FilterClass1();
        Filter filter2 = new FilterClass2();

        /*2.0 内部类形式实现——内部类的参数使用都是final*/
        Filter filter3 = new Filter() {
            private static final String phone = "12081273891";
            @Override
            public boolean match(PersonModel personModel) {
                return phone.equals(personModel.getPhone());
            }
        } ;

        /*3.0 lambda表达式代替匿名内部类*/
        List<PersonModel> personModel = myFilter.test(list, (person) ->
                                            {   final String phone = "12081273891";
                                                return phone.equals(person.getPhone());});
        personModel.forEach(p -> {System.out.println(p.getName());});

      /*  *//*可以使用lambda表达式简化系统中的匿名内部类*//*
        Runnable runnable = () -> {System.out.print("lsj");};
        Thread thread = new Thread(runnable);
        thread.start();*/

    }

    /**
     * 5.0 在接口中可以定义默认实现方法和静态方法
     */
    public static void test2(){
        Filter.staticMethod();

        Filter filter1 = new FilterClass1();
        Filter filter2 = new FilterClass2();

        filter1.defaultMethod();
        filter2.defaultMethod();
    }

}
