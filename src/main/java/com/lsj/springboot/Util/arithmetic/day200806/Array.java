package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目1:2数之和
 *
 * 题目88 (10.01). 合并排序的数组
 *
 * 题目485:最大连续1的个数
 *
 * 题目15:三数之和
 *
 * 题目495:中毒总时长
 *
 * 题目21:合并两个有序链表（数组）
 *
 * 题目605:种花问题
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 题目34：在排序数组中查找元素的第一个和最后一个位置（Offer 53 - I）
 *
 * 题目189：旋转数组
 *
 * 题目1099：小于 K 的两数之和
 */
public class Array {

    public static void main(String[] args){
      /*  int[] A = {1,2,3,0,0,0};
        int m = 3;
        int[] B = {2,5,6};
        int n = 3;
        merge(A, m, B, n);
        System.out.println(A);*/
     /*   int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);*/
//        int[] nums = new int[]{0,1,0,3,12};
//        moveZeroes(nums);
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }

    /**
     * 1.从无序数组中找到2数
     * @param nums
     * @param target
     */
    public static void findTrueBumInUnorderedList(int[] nums, int target){
        if (nums == null || nums.length < 1){
            return;
        }
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    System.out.println(nums[i] + ";" + nums[j]);
                }
            }
        }
    }

    /**
     * 1.从有序数组中找到2数
     * @param nums
     * @param target
     */
    public static void findTrueBumInOrderedList(int[] nums, int target){
        if (nums == null || nums.length < 0){
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            if(nums[start] + nums[end] == target){
                System.out.println(nums[start] + ";" + nums[end]);
                start++;
            }else if(nums[start] + nums[end] < target){
                start++;
            }else {
                end--;
            }
        }
    }



    /**
     * 题目88 (10.01). 合并排序的数组
     * 输入: A = [1,2,3,0,0,0], m = 3;  B = [2,5,6],  n = 3 输出: [1,2,2,3,5,6] 先将A数组中的m个元素移动到末尾；
     * 然后利用归并排序的merge思想，每次取出A和B数组头元素中的最小值逐个放到A数组中。
     * 以上说法有点抽象，我们举个例子吧。假设A = [1,2,3,0,0,0], B = [2,5,6] A=[1,2,3,0,0,0],B=[2,5,6]。A数组元素的变化过程如下：
     * [0,0,0,1,2,3][1,0,0,1,2,3][1,2,0,0,0,3][1,2,2,0,0,3][1,2,2,3,0,0][1,2,2,3,5,0][1,2,2,3,5,6]
     * 说明：以上元素被移动到正确的位置上后，其实无需置0（为了演示看起来更加直观，置0）。
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
      /* public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        Object src : 原数组
        int srcPos : 从元数据的起始位置开始
    　　Object dest : 目标数组
    　　int destPos : 目标数组的开始起始位置
    　　int length  : 要copy的数组的长度*/
        // 先将A右移到末尾
        System.arraycopy(A, 0, A, n, m);
        int index = 0;
        int indexA, indexB;
        // 归并排序 merge
        for(indexA = n, indexB = 0; indexA < m + n && indexB < n;){
            if(A[indexA] >= B[indexB]){
                A[index++] = B[indexB++];
            }else{
                A[index++] = A[indexA++];
            }
        }
        // A中还有剩余元素
        while(indexA < m + n){
            A[index++] = A[indexA++];
        }
        // B中还有剩余元素
        while(indexB < n){
            A[index++] = B[indexB++];
        }
    }

    /**
     * 485. 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * 输入: [1,1,0,1,1,1]  输出: 3
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                temp++;
            }else{
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        if(temp != 0){
            max = Math.max(max, temp);
        }
        return max;
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：[[-1, 0, 1],[-1, -1, 2]]
     * @param nums
     * @return
     */
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
            List<Integer> sumZero = new ArrayList<>();
            if(nums[start] + nums[end] == target){
                sumZero.add(-target);
                sumZero.add(nums[start]);
                sumZero.add(nums[end]);
                start++;
            }else if(nums[start] + nums[end] < target){
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


    /**
     * 495.中毒总时长
     * 输入: [1,4], 2  输出: 4
     原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
     第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
     所以最终输出 4 秒。
     输入: [1,2], 2 输出: 3
     原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
     但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
     由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
     所以最终输出 3 。
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0){
            return 0;
        }
        int total = 0;
        for(int i = 0; i < timeSeries.length - 1; i++){
            // if(timeSeries[i] + duration < timeSeries[i + 1]){
            //     total += duration;
            // } else{
            //     total += timeSeries[i + 1] - timeSeries[i];
            // }
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        total += duration;
        return total;
    }

    /**
     * 21.合并两个有序链表(链表合并的数组版)
     * 将2个升序链表合并为一个新的升序链表并返回
     * 1->5->6, 1->3->4->6
     * @param firstList
     * @param secondList
     * @return
     */
    public static Integer[] combine(Integer[] firstList, Integer[] secondList){
        if(firstList == null || firstList.length == 0){
            return secondList;
        }else if(secondList == null || secondList.length == 0){
            return firstList;
        }
        List<Integer> combine = new ArrayList<>();
        for(int i = 0, j = 0; i < firstList.length && j < secondList.length;){
            if(firstList[i] == secondList[j]){
                combine.add(firstList[i]);
                i++;j++;
            }else {
                int max = Math.max(firstList[i], secondList[j]);
                if(firstList[i] == max){
                    combine.add(secondList[j]);
                    j++;
                }else if(secondList[j] == max){
                    combine.add(firstList[i]);
                    i++;
                }
            }
        }
        return combine.toArray(new Integer[combine.size()]);
    }

    /**
     * 605. 种花问题
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     *  输入: flowerbed = [1,0,0,0,1], n = 1 输出: True;                输入: flowerbed = [1,0,0,0,1], n = 2 输出: False
     *  注意:1.数组内已种好的花不会违反种植规则。2.输入的数组长度范围为 [1, 20000]。3. n 是非负整数，且不会超过输入数组的大小。
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null){
            return false;
        }
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            //贪心算法
            // 当前节点如果是头结点：当前节点是0，下一个节点是0，可种植数+1，当前节点由0变1；
            // 当前节点如果是尾结点：当前节点是0，前一个节点是0，可种植数+1，当前节点由0变1；
            // 中间节点：当前节点是0，前一个节点是0，后一个节点是0，可种植数+1，当前节点由0变1；
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1  || flowerbed[i + 1] == 0)){
                count ++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }

    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * 输入: nums = [5,7,7,8,8,10], target = 8    输出: 2
     * 输入: nums = [5,7,7,8,8,10], target = 6    输出: 0
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                count++;
                continue;
            }
            if(count > 0){
                break;
            }
        }
        return count;
    }

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * 输入: [0,1,3]  输出: 2
     * 输入: [0,1,2,3,4,5,6,7,9]  输出: 8
     * 输入: [1,2,3]  输出: 0
     *  输入: [0,1,2,3]  输出: 4
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        // 类似于贪心算法的种花问题
        int target = 0;
        if(nums[0] == 1){// 如果跳过了0
            return target;
        }
        for(int i = 0; i < nums.length; i++){
            if((i == 0 || nums[i] - nums[i - 1] == 1) &&
                    (i == nums.length - 1 || nums[i + 1] - nums[i] == 1)){
                continue;
            }
            target = nums[i] + 1;
            break;
        }
        if(target == 0){// 如果是连续(跳过最后一个)
            target = nums[nums.length - 1] + 1;
        }
        return target;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *  你的算法时间复杂度必须是 O(log n) 级别。
     *  如果数组中不存在目标值，返回 [-1, -1]。
     *  输入: nums = [5,7,7,8,8,10], target = 8   输出: [3,4]
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ints = new int[]{-1, -1};
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                if(ints[0] == -1){
                    ints[0] = i;
                }
                count++;
            }else{
                if(count > 0){
                    break;
                }
            }
        }
        if(count > 0){
            ints[1] = ints[0] + count - 1;
        }
        return ints;
    }

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: [1,2,3,4,5,6,7] 和 k = 3   输出: [5,6,7,1,2,3,4]
         解释:
         向右旋转 1 步: [7,1,2,3,4,5,6]
         向右旋转 2 步: [6,7,1,2,3,4,5]
         向右旋转 3 步: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // for(int i = 1; i <= k; i++){//移动k次
        //     int temp = nums[nums.length - 1];
        //     for(int j = nums.length - 1; j > 0; j--){
        //         nums[j] = nums[j - 1];
        //     }
        //     nums[0] = temp;
        // }

        k %= nums.length;
        if(k == 0) return;
        reverse(nums, 0, nums.length - 1);// 所有数组反转
        reverse(nums, 0, k - 1);// 前k个数组反转
        reverse(nums, k, nums.length - 1);// 后n - k个数组反转
    }

    // 数组反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 1099. 小于 K 的两数之和
     * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
     如不存在这样的两个元素，请返回 -1。
     输入：A = [34,23,1,24,75,33,54,8], K = 60  输出：58
     解释： 34 和 24 相加得到 58，58 小于 60，满足题意。
     * @param A
     * @param K
     * @return
     */
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int start = 0;
        int end = A.length - 1;
        int ans = -1;
        while(start < end){
            if(A[start] + A[end] >= K){
                end--;
            }else{
                ans = Math.max(A[start] + A[end], ans);
                start++;
            }
        }
        return ans;
    }
}
