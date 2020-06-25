package com.lsj.springboot.Util.arithmetic.day200622;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目一
 * 1.给定一个无序数组，找到正确的数
 * 2.给定一个有序数组，找到正确的数
 */
public class FindTrueNum {

    private static List<Integer> unorderedList = new ArrayList<>();
    private static List<Integer> orderedList = new ArrayList<>();

    static {
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(5);
        orderedList.add(6);
        orderedList.add(7);

        unorderedList.add(3);
        unorderedList.add(9);
        unorderedList.add(6);
        unorderedList.add(5);
        unorderedList.add(1);
    }

    public static void main(String[] args){
//        findTrueBumInUnorderedList(unorderedList, 8);
        findTrueBumInOrderedList(orderedList, 8);
    }

    /**
     * 从无序数组中找到2数
     * @param list
     * @param target
     */
    public static void findTrueBumInUnorderedList(List<Integer> list, int target){
        if (list == null || list.isEmpty()){
            return;
        }

        for(int i = 0; i < list.size() -1; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == target){
                    System.out.println(list.get(i) + ";" + list.get(j));
                }
            }
        }
    }

    public static void findTrueBumInOrderedList(List<Integer> list, int target){
        if (list == null || list.isEmpty()){
            return;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start < end){
            int firstNum = list.get(start);
            int lastNum = list.get(end);
            if(firstNum + lastNum == target){
                System.out.println(firstNum + ";" + lastNum);
                start++;
            }else if(firstNum + lastNum < target){
                start++;
            }else {
                end--;
            }
        }
    }

}
