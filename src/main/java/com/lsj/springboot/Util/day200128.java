package com.lsj.springboot.Util;

import java.util.*;

/**
 * Created by 10326 on 2020/1/28.
 * 按照key进行降序（排序）
 */
public class day200128 {

    public static void main(String[] args) {
        /**
         * TreeMap
         */
        TreeMap<String,Integer> map = new TreeMap<>((o1, o2) -> {
            String i1= o1;
            String i2= o2;
            return -i1.compareTo(i2);
        });
        map.put("key_1", 3);
        map.put("key_3", 2);
        map.put("key_2", 1);
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println(" "+key+":"+map.get(key));
        }
        
        List<Integer> list = new ArrayList();
        list.add(18);
        list.add(10);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        /**
         * 错误代码，根源在于集合删掉元素以后，i++，不会报错但是会导致数据结果不准确
         * 删掉元素后面的那个元素会前移，掉到删除元素的位置
         */
        /*for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 == 0){
                list.remove(i);
            }
        }
        System.out.println(list);*/

        /**
         * 报错，循环的数组还是原来的长度
         */
     /*   for (int i : list) {
            if(list.get(i) % 2 == 0){
                list.remove(i);
            }
        }
        System.out.println(list);*/

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            if((int)iterator.next() % 2 == 0){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
