package com.lsj.springboot.Util.arithmetic.day200622;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目一
 * 1.给定一个无序数组，找到正确的数
 * 2.给定一个有序数组，找到正确的数
 *
 * 题目15 三数之和，借助双指针
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
//        findTrueBumInOrderedList(orderedList, 8);
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);
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

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            // 不能包含重复的3元组
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            target = -nums[i];
            // 求子数组
            int[] subNums = Arrays.copyOfRange(nums, i + 1, nums.length);
            List<List<Integer>> twoSumList = twoSum(subNums, target);
            if(twoSumList.size() != 0) {
                result.addAll(twoSumList);
            }
        }
        return result;

    }

    // 求2数之和
    public static List<List<Integer>> twoSum(int[] nums, int target){
        List<List<Integer>> sumZeros = new ArrayList<>();
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            // 解决 [0,0,0,0] 测试用例的问题
            if(start > 0 && nums[start] == nums[start - 1]){
                start++;
                continue;
            }else if(end < nums.length - 1 && nums[end] == nums[end + 1]){
                end--;
                continue;
            }
            int firstNum = nums[start];
            int lastNum = nums[end];
            List<Integer> sumZero = new ArrayList<>();
            if(firstNum + lastNum == target){
                sumZero.add(-target);
                sumZero.add(firstNum);
                sumZero.add(lastNum);
                start++;
            }else if(firstNum + lastNum < target){
                start++;
            }else {
                end--;
            }
            if(sumZero.size() > 0) {
                sumZeros.add(sumZero);
            }
        }
        return sumZeros;
    }

}
