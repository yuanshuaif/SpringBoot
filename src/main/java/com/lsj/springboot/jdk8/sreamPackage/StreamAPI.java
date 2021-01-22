package com.lsj.springboot.jdk8.sreamPackage;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 10326 on 2019/4/20.
 * 3.0 Stream
 * 创建流
 * 1.stream是对集合对象功能的增强
 * 2.parallelStream：并发流
 * 中间操作
 * 2.filter:遍历集合，并检查其中的元素是否可用（过滤）（中间操作）
 * 3.map:一对一的映射，生成一个新的集合（中间操作）
 * 4.flatmap:一对多的映射（中间操作）/返回数据类型不同
 * 7.peek：可以查看每个值，同时能继续操作流
 * 终止操作
 * 5.collect：在流中生成列表，map，等常用的数据结构（终止操作）(findFirst)
 *
 *
 * 4.0.Optional容器:相关API ，是对空指针异常的优化解决方案
 */
public class StreamAPI {

    /**
     * 过滤得到年龄大于28的人——filter
     */
    public static void filterByAge(){

        Optional<PersonModel> opt = Data.getData().stream().filter(personModel ->
             personModel.getAge() >= 26
        ).findFirst();

        System.out.println(opt.orElseGet(PersonModel::new));

    }

    /**
     * 获取名称集合——map
     */
    public static void nameList(){

       /* List<Integer> list = Data.getData().stream().map(personModel -> personModel.getAge()).
                peek(age -> System.out.println(age)).collect(Collectors.toList());*/

       // peek:读取输出
        List<Integer> list = Data.getData().stream().map(PersonModel::getAge).
                peek(age -> System.out.println(age)).collect(Collectors.toList());
//        System.out.println(list);

    }

    /**
     * flatmap
     */
    public static void flatMap(){
        /*流数组作为整体转换成集合*/
        List<Stream<String>> list1 = Data.getData().stream().map(personModel -> Arrays.asList(personModel.getName()).stream())
                .collect(Collectors.toList());
        /*每个流单独转化成集合，放到数组中*/
        List<String> list2 = Data.getData().stream().flatMap(personModel -> Arrays.asList(personModel.getName()).stream())
                .collect(Collectors.toList());

        System.out.println(list1);
        System.out.println(list2);

    }

    /**
     *并发能力
     */
    public static void parallelStream(List<PersonModel> list){
        // 并发
        list.parallelStream().forEach(personModel -> {
            if("yuanshuai".equals(personModel.getName())){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("parallelStream:" + personModel.getName());
        });
        // 同步
        list.stream().forEach(personModel -> {
            if("yuanshuai".equals(personModel.getName())){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("stream:" + personModel.getName());
        });
    }
    public static void main(String[] args){
//        filterByAge();
//        nameList();
//        flatMap();
        parallelStream(Data.getData());
    }
}
