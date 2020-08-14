package com.lsj.springboot.Util.arithmetic.day200812;

import java.util.*;

/**
 * 349. 两个数组的交集
 *
 * 704. 二分查找
 *
 * 69. x 的平方根
 *
 * 35. 搜索插入位置
 *
 * 350. 两个数组的交集 II
 * hash表
 *
 * 367. 有效的完全平方数(类似于69题)
 */
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

//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < nums1.length; i++){
//            for(int j = 0; j < nums2.length; j++){
//                if(nums1[i] == nums2[j]){
//                    set.add(nums1[i]);
//                }
//            }
//        }
//        Integer[] integers = set.toArray(new Integer[0]);
//        int[] ints = new int[integers.length];
//        for(int i = 0; i < integers.length; i++){
//            ints[i] = integers[i];
//        }
//        return ints;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }
        if(set1.size() > set2.size()){
            return intersectionSub(set2, set1);
        }else {
            return intersectionSub(set1, set2);
        }
    }

    public int[] intersectionSub(Set<Integer> set1, Set<Integer> set2){
        int[] ints = new int[set1.size()];
        int i = 0;
        for(Integer s : set1){
            if(set2.contains(s)){
                ints[i++] = s;
            }
        }
        return Arrays.copyOf(ints, i);
    }

    /**
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 输入: nums = [-1,0,3,5,9,12], target = 9   输出: 4   解释: 9 出现在 nums 中并且下标为 4
     * 输入: nums = [-1,0,3,5,9,12], target = 2   输出: -1  解释: 2 不存在 nums 中因此返回 -1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                ans = mid;
                break;
            }
        }
        return ans;
    }

    /**
     *  69. x 的平方根
     *  实现 int sqrt(int x) 函数。  计算并返回 x 的平方根，其中 x 是非负整数。
         由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
         输入: 8   输出: 2   说明: 8 的平方根是 2.82842...,     由于返回类型是整数，小数部分将被舍去。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // k2<=x （求k的最大整数）
        long start = 0;
        long end = x;
        int k = 0;
        while(start <= end){
            // 此处注意使用long类型
            long mid = (start + end) / 2;
            if(mid * mid < x){
                start = mid + 1;
                k = (int)mid;// 最接近的值，小于的话也可以
            }else if( mid * mid > x){
                end = mid - 1;
            }else{
                k = (int)mid;
                break;
            }
        }
        return k;
    }

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。(无重复数组)
     * 输入: [1,3,5,6], 5 输出: 2
     * 输入: [1,3,5,6], 2 输出: 1
     * 输入: [1,3,5,6], 7 输出: 4
     * 输入: [1,3,5,6], 0 输出: 0
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        if(target < nums[start]){
            return 0;
        }else if(target > nums[end - 1]){
            return nums.length;
        }
        int k = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
                k = mid + 1;
            }else if( nums[mid] > target){
                end = mid - 1;
            }else{
                k = mid;
                break;
            }
        }
        return k;
    }

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]  输出：[2,2]
     * 时间复杂度：O(m+n)         空间复杂度：O(\min(m,n))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // hash表的方式
        if(nums1.length > nums2.length){
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for(Integer integer : nums1){
            Integer count = hash.getOrDefault(integer, 0) + 1;
            hash.put(integer, count);
        }
        int[] ans = new int[nums1.length];
        int k = 0;
        for(int i = 0; i < nums2.length; i++){
            Integer count = hash.getOrDefault(nums2[i], 0);
            if(count > 0){
                ans[k++] = nums2[i];
                count--;
                hash.put(nums2[i], count);
            }
        }
        return Arrays.copyOf(ans, k);
    }

    /**
     * 367. 有效的完全平方数
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
        说明：不要使用任何内置的库函数，如  sqrt。
        输入：16 输出：True    输入：14 输出：false
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        // k2=num 使用二分查找法找到一个k使得等式成立
        long start = 0;
        long end = num;
        boolean flag = false;
        while(start <= end){
            // 注意int的最大值问题 2147483647
            long mid = (start + end) / 2;
            if(mid * mid > num){
                end = mid - 1;
            }else if(mid * mid < num){
                start = mid + 1;
            }else{
                flag = true;
                break;
            }
        }
        return flag;
    }
}
