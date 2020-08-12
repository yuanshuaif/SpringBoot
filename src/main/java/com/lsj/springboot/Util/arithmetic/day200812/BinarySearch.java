package com.lsj.springboot.Util.arithmetic.day200812;

import java.util.HashSet;
import java.util.Set;

public class BinarySearch {

    public static void main(String[] args){

    }

    /**
     * 349. 两个数组的交集
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]  输出：[2]
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]  输出：[9,4]
     *
     * 注意：输出结果中的每个元素一定是唯一的。   我们可以不考虑输出结果的顺序。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }
        Integer[] integers = set.toArray(new Integer[0]);
        int[] ints = new int[integers.length];
        for(int i = 0; i < integers.length; i++){
            ints[i] = integers[i];
        }
        return ints;

    }
}
