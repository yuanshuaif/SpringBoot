package com.lsj.springboot.arithmetic.array;

import java.util.*;

/**
 * 题目1:2数之和
 *
 * 题目485:最大连续1的个数
 *
 * 题目495:中毒总时长
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 题目34:在排序数组中查找元素的第一个和最后一个位置（Offer 53 - I）
 *
 * 题目189:旋转数组
 *
 * 题目1099:小于 K 的两数之和
 *
 * 题目905：按奇偶排序数组
 *
 * 题目1287:有序数组中出现次数超过25%的元素
 *
 * 题目1528:重新排列字符串
 *
 * 题目561:数组拆分 I
 *
 * 题目941:有效的山脉数组
 *
 * 题目118:杨辉三角
 *
 * 题目442:数组中重复的数据
 *
 * 题目119:杨辉三角 II
 *
 * 题目448:找到所有数组中消失的数字
 *
 * 题目66:加一
 *
 * 题目560:和为K的子数组
 *
 * 题目1480:一维数组的动态和
 *
 * 题目674. 最长连续递增序列
 *
 * 题目4. 寻找两个正序数组的中位数
 *
 * 题目48:旋转图像
 * 面试题 01.07. 旋转矩阵
 *
 * 题目54:螺旋矩阵
 *
 * 剑指 Offer 29. 顺时针打印矩阵
 *
 * 题目867:转置矩阵
 *
 * 题目566:重塑矩阵
 */
public class Array {

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
     * 495.中毒总时长
     * 输入: [1,4], 2  输出: 4
     * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
     * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。所以最终输出 4 秒。
     * 输入: [1,2], 2 输出: 3
     * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
     * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。所以最终输出 3 。
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
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        total += duration;
        return total;
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
     * 输入: [1,2,3]  输出: 0;   输入: [0,1,2,3,4,5,6,7,9]  输出: 8;  输入: [0,1,2,3]  输出: 4
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
       for(int i = 0; i < nums.length; i++){
           if(i < nums[i])  return i;
       }
       return nums[nums.length - 1] + 1;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。如果数组中不存在目标值，返回 [-1, -1]。
     * 输入: nums = [5,7,7,8,8,10], target = 8   输出: [3,4]
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
     * 解释:向右旋转 1 步: [7,1,2,3,4,5,6]     向右旋转 2 步: [6,7,1,2,3,4,5]   向右旋转 3 步: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        reverse(nums, 0, nums.length - 1);// 1.所有数组反转
        reverse(nums, 0, k - 1);// 2.前k个数组反转
        reverse(nums, k, nums.length - 1);// 3.后n - k个数组反转
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
     * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。如不存在这样的两个元素，请返回 -1。
     * 输入：A = [34,23,1,24,75,33,54,8], K = 60  输出：58    解释： 34 和 24 相加得到 58，58 小于 60，满足题意。
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

    /**
     * 905. 按奇偶排序数组
     * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。你可以返回满足此条件的任何数组作为答案。
     * 输入：[3,1,2,4] 输出：[2,4,3,1]     输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int temp = 0;
        int start = 0;
        int end = A.length - 1;
        while(start < end){
            while((A[start] & 1) == 0 && start < end){//偶数
                start++;
            }
            while((A[end] & 1) == 1 && start < end){//奇数
                end--;
            }
            if(start < end){
                temp = A[start];
                A[start] = A[end];
                A[end] = temp;
            }
        }
        return A;
    }

    /**
     * 1287. 有序数组中出现次数超过25%的元素
     * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
     * 输入：arr = [1,2,2,6,6,6,6,7,10]    输出：6；    [1,2,3,3] 3
     * @param arr
     * @return
     */
    public int findSpecialInteger(int[] arr) {
        double target = (double)arr.length / 4;
        // Map<Integer, Integer> hash = new HashMap<>();
        // for(int i = 0; i < arr.length; i++){
        //     hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        // }
        // for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
        //     if(entry.getValue() > target){
        //         return entry.getKey();
        //     }
        // }
        int temp = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]){
                temp++;
            }else{
                if(temp > target){
                    return arr[i - 1];
                }
                temp = 1;
            }
        }
        if(temp > target){
            return arr[arr.length - 1];
        }
        return 0;
    }

    /**
     * 1528. 重新排列字符串
     * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
     * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。返回重新排列后的字符串。
     * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]   输出："leetcode"   解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
     * 输入：s = "abc", indices = [0,1,2]  输出："abc"    解释：重新排列后，每个字符都还留在原来的位置上。
     *
     * 1.s.length == indices.length == n    2.1 <= n <= 100     3.s 仅包含小写英文字母。   4.0 <= indices[i] < n
     * 5.indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
     * @param s
     * @param indices
     * @return
     */
    public static String restoreString(String s, int[] indices) {
        /*Map<Integer, Character> hash = new HashMap<>();
        for(int i = 0; i < indices.length; i++){
            hash.put(indices[i], s.charAt(i));
        }
        Arrays.sort(indices);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indices.length; i++){
            sb.append(hash.get(indices[i]));
        }
        return sb.toString();*/
        char[] result = new char[indices.length];
        for(int i = 0; i < indices.length; i++){
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }

    /**
     * 561. 数组拆分 I
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     * 输入: [1,4,3,2]    输出: 4    解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
     * 1.n 是正整数,范围在 [1, 10000].     2.数组中的元素范围在 [-10000, 10000].
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i = i + 2){
            ans += nums[i];
        }
        return ans;
    }

    /**
     * 941. 有效的山脉数组
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * A.length >= 3    在 0 < i < A.length - 1 条件下，存在 i 使得： A[0] < A[1] < ... A[i-1] < A[i]     A[i] > A[i+1] > ... > A[A.length - 1]
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int peekIndex = 0;
        for(int i = 1; i < A.length - 1; i++){
            if(peekIndex == 0){
                if(A[i] <= A[i - 1]){// 山峰之前递增
                    return false;
                }
                if(A[i] > A[i - 1] && A[i] > A[i + 1]){// 山峰的位置
                    peekIndex = i;
                }
            }else{
                if(A[i] >= A[i - 1]){// 山峰之后递减
                    return false;
                }
            }
        }
        return peekIndex != 0 && A[A.length - 1] < A[A.length - 2];
    }

    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 输入: 5        输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1){
            return res;
        }
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    temp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }

            }
            res.add(temp);
        }
        return res;
    }

    /**
     * 442. 数组中重复的数据
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。找到所有出现两次的元素。
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     * 输入:[4,3,2,7,8,2,3,1]            输出:[2,3]
     * 核心算法：1.找到数字i时，将位置i-1处的数字翻转为负数。   2.如果位置i-1 上的数字已经为负，则i是出现两次的数字。
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]) - 1;
            if(nums[temp] < 0){
                res.add(Math.abs(nums[i]));
            }
            nums[temp] = -nums[temp];
        }
        return res;
    }

    /**
     * 119. 杨辉三角 II
     * 输入: 3    输出: [1,3,3,1]
     * 公式法：numVal = (n - i) / i * res.get(i - 1)
     * 动态规划
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            res = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    res.add(1);
                }else{
                    res.add(pre.get(j) + pre.get(j - 1));
                }

            }
            pre = res;
        }
        return res;
    }

    /**
     * 448. 找到所有数组中消失的数字
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * 输入:[4,3,2,7,8,2,3,1]     输出:[5,6]
     * 核心算法：1.找到数字i时，将位置i-1处的数字翻转为负数。 2.大于0的位置+1就是缺失的数字
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 输入: [1,2,3]      输出: [1,2,4]     解释: 输入数组表示数字 123。           [9,9]  [1,0,0]
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        // int index = -1;
        // for(int i = 0; i < digits.length; i++){
        //     if(digits[i] != 9){
        //         index = i;
        //     }
        // }
        // int[] res;
        // if(index == -1){// 全是9
        //     res = new int[digits.length + 1];
        //     res[0] = 1;
        // }else{
        //     res = new int[digits.length];
        //     for(int i = 0; i < digits.length; i++){
        //         if(i < index){
        //             res[i] =  digits[i];
        //         }else if(i == index){
        //             res[i] = 1 + digits[i];
        //         }
        //     }
        // }
        // return res;

        //1.找到最后一个不为9的数字下标
        int index = -1;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                index = i;
            }
        }
        int[] res;
        if(index == -1){// 2.全是9
            res = new int[digits.length + 1];
            res[0] = 1;
            digits = res;

        }else{//3.不为9的下标+1，后面的全是0
            for(int i = 0; i < digits.length; i++){
                if(i == index){
                    digits[i] += 1;
                }if(i > index){
                    digits[i] = 0;
                }
            }
        }
        return digits;
    }

    /**
     * 560. 和为K的子数组
     * 历史和+哈希表
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * 示例 1 :输入:nums = [1,1,1], k = 2   输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 1.数组的长度为 [1, 20,000]。    2.数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     * pre[j−1]==pre[i]−k
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
       int count = 0;
       int pre = 0;
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 1);// pre - k 等于0，但是没有统计到，所以需要初始化值为1
       for(int i = 0; i < nums.length; i++){
           pre += nums[i];
           if(map.containsKey(pre - k)){
               count += map.get(pre - k);
           }
           map.put(pre, map.getOrDefault(pre, 0) + 1);
       }
       return count;
    }

    /**
     * 1480. 一维数组的动态和
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。请返回 nums 的动态和。
     * 输入：nums = [1,2,3,4]  输出：[1,3,6,10]   解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    /**
     * 674. 最长连续递增序列
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
     * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     *
     * 输入：nums = [1,3,5,4,7]        输出：3        解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     *
     * 输入：nums = [2,2,2,2,2]        输出：1        解释：最长连续递增序列是 [2], 长度为1。
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            count = nums[i - 1] < nums[i] ? ++count : 1;
            ans = Math.max(ans, count);
        }
        return ans;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 输入：nums1 = [1,3], nums2 = [2]    输出：2.00000  解释：合并数组 = [1,2,3] ，中位数 2
     * 输入：nums1 = [1,2], nums2 = [3,4]  输出：2.50000  解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 输入：nums1 = [], nums2 = [1]   输出：1.00000
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            if((nums2.length & 1) == 0){
                return (double)(nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
            }else{
                return nums2[nums2.length / 2];
            }
        } else if(nums2.length == 0){
            if((nums1.length & 1) == 0){
                return (double)(nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2;
            }else{
                return nums1[nums1.length / 2];
            }
        }
        int[] sums = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int k = 0;
        for(; i < nums1.length && j < nums2.length;){
            if(nums1[i] < nums2[j]){
                sums[k++] = nums1[i++];
            }else if(nums1[i] > nums2[j]){
                sums[k++] = nums2[j++];
            }else{
                sums[k++] = nums1[i++];
                sums[k++] = nums2[j++];
            }
        }
        if(i < nums1.length){
            while(i < nums1.length){
                sums[k++] = nums1[i++];
            }
        }
        if(j < nums2.length){
            while(j < nums2.length){
                sums[k++] = nums2[j++];
            }
        }
        if((sums.length & 1) == 0){
            return (double)(sums[sums.length / 2] + sums[sums.length / 2 - 1]) / 2;
        }else{
            return sums[sums.length / 2];
        }
    }

    /**
     * 48. 旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
     * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * 给定 matrix =                 原地旋转输入矩阵，使其变为:
     * [                                  [
     *   [1,2,3],         1,4,7              [7,4,1],
     *   [4,5,6],         2,5,8              [8,5,2],
     *   [7,8,9]          3,6,9              [9,6,3]
     * ],                                 ]
     * 算法核心：先转置矩阵（对角线），然后翻转每一行
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    /**
     * 54. 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * 输入:   [[1, 2, 3, 4],
     *          [5, 6, 7, 8],
     *          [9,10,11,12]]           输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        // 辅助矩阵，代表是否访问过
        boolean[][] visited = new boolean[rows][cols];
        // 定义方向数组以及初始方向
        int directionIndex = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 定义当前位置
        int row = 0, col = 0;
        // 终止条件：总共需要走多少个节点
        int total = rows * cols;
        for(int i = 0; i < total; i++){
            ans.add(matrix[row][col]);
            visited[row][col] = true;// 标记该节点已经访问
            // 获取在当前方向上移动后的下一个节点
            int newRow = row + directions[directionIndex][0], newCol = col + directions[directionIndex][1];
            // 判断新的节点是否符合转向
            if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || visited[newRow][newCol]){
                directionIndex = (directionIndex + 1) % 4;
            }
            // 获取转向后新的行和列
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return ans;
    }

    /**
     * 剑指 Offer 29. 顺时针打印矩阵(54. 螺旋矩阵)
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 输入：matrix = [[1,2,3,4],
     *                 [5,6,7,8],
     *                 [9,10,11,12]]       输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * 核心思想：一层一层的打
     * @param matrix
     * @return
     */
    public static int[] spiralOrder1(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[] ans = new int[rows * cols];
        int curIndex = 0;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while(left <= right && top <= bottom){
            for(int i = left; i <= right; i++){//1,2,3,4
                ans[curIndex++] = matrix[top][i];
            }
            for(int i = top + 1; i <= bottom; i++){//8,12
                ans[curIndex++] = matrix[i][right];
            }
            if(left < right && top < bottom){// 一条直线或一个点时没必要进行后面的操作
                for(int i = right - 1; i >= left; i--){//11,10
                    ans[curIndex++] = matrix[bottom][i];
                }
                for(int i = bottom - 1; i > top; i--){//9,5
                    ans[curIndex++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    /**
     * 867. 转置矩阵
     * 给定一个矩阵 A， 返回 A 的转置矩阵。矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]     输出：[[1,4,7],[2,5,8],[3,6,9]]
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int temp = 0;
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[col][row];
        // 转置矩阵
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }

    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * 输入:nums =[[1,2],[3,4]]r = 1, c = 4       输出:[[1,2,3,4]]       解释:行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * 输入:nums =[[1,2],[3,4]]r = 2, c = 4       输出:[[1,2],[3,4]]     解释:没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if(row * col != r * c || col == c){
            return nums;
        }
        int count = 0;
        int[][] ans = new int[r][c];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return ans;
    }


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
//        System.out.println(restoreString("aiohn", new int[]{3,1,4,2,0}));
        int[][] a = new int[][]{{1,2,3,4,13},{5,6,7,8,14},{9,10,11,12,15}};
        System.out.println(spiralOrder1(a));
//        System.out.println(subarraySum(new int[]{1,1,1}, 2));
//        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));

    }
}
