package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.SortedMap;
import java.util.TreeMap;

public class Hash {
    private static String go(String client) {
        int nodeCount = 20;
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (String s : new Servers().list) {
            for (int i = 0; i < nodeCount; i++)
                treeMap.put((s + "--服务器---" + i).hashCode(), s);
        }
        int clientHash = client.hashCode();
        // fisrtKey()	K	获取第一个（排在最低的）对象的 Key
        //lastKey()	K	获取最后个（排在最高的）对象的 Key
        //headMap(K toKey)	SortedMap<K,V>	获取一个子集。其所有对象的 key 的值小于 toKey
        //subMap(K fromKey, K toKey)	SortedMap<K,V>	获取一个子集。其所有对象的 key 的值小于 toKey ，大于等于 fromKey
        //tailMap(K fromKey)	SortedMap<K,V>	获取一个子集。其所有对象的 key 的值大于等于 fromKey
        SortedMap<Integer, String> subMap = treeMap.tailMap(clientHash);
        Integer firstHash;
        if (subMap.size() > 0) {
            firstHash = subMap.firstKey();
        } else {
            firstHash = treeMap.firstKey();
        }
        String s = treeMap.get(firstHash);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(go("今天天气不错啊"));
        System.out.println(go("192.168.5.258"));
        System.out.println(go("0"));
        System.out.println(go("-110000"));
        System.out.println(go("风雨交加"));
    }
}
