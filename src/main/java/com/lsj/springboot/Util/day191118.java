package com.lsj.springboot.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10326 on 2019/11/18.
  transformedBeanNameCache.computeIfAbsent(name, beanName -> {
 do {
 beanName = beanName.substring(BeanFactory.FACTORY_BEAN_PREFIX.length());
 }
 while (beanName.startsWith(BeanFactory.FACTORY_BEAN_PREFIX));
 return beanName;
 }
 */
public class day191118 {

    public static void main(String[] args){

        Map<String, Object> map = initMap();
        // java8之前。从map中根据key获取value操作可能会有下面的操作
      /*  Object value = map.get("key");
        if (value == null) {
            value = "1234";
            map.put("key", value);
        }*/

        // java8之后。上面的操作可以简化为一行，若key对应的value为空，会将第二个参数的返回值存入并返回
        Object key2 = map.computeIfAbsent("key", val -> "123345");

        System.out.println(map.toString());
        System.out.println(key2);
    }

    public static Map<String, Object> initMap(){
        Map<String, Object> map = new HashMap<>();
//        map.put("key", "123");
        map.put("value", 234);
        return map;
    }


}
