package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.*;

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
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 题目34：在排序数组中查找元素的第一个和最后一个位置（Offer 53 - I）
 *
 * 题目189：旋转数组
 *
 * 题目1099：小于 K 的两数之和
 *
 * 905. 按奇偶排序数组
 *
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * 1086. 前五科的均分
 *
 * 1528. 重新排列字符串
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

    /**
     * 905. 按奇偶排序数组
     * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
     * 你可以返回满足此条件的任何数组作为答案。
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
     * 请你找到并返回这个整数
     * 输入：arr = [1,2,2,6,6,6,6,7,10]    输出：6
     * [1,2,3,3] 3
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
        if(arr.length == 1){
            return arr.length;
        }
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
     * 1086. 前五科的均分
     * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
     * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
     * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
     * 输出：[[1,87],[2,88]]
     * 解释：id = 1 的学生平均分为 87。id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
     * @param items
     * @return
     */
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);// id升序，成绩降序
        int num = items[items.length - 1][0];// 最后一个学生的id
        int[][] result = new int[num][2];
        for(int i = 0; i < items.length; i++){
            if(i == 0 || items[i][0] != items[i - 1][0]){// 第一个学生或者是下一个学生
                int id = items[i][0];
                result[id - 1][0] = id;
                int sum = 0;
                for(int j = i; j < i + 5; j++){
                    sum += items[j][1];
                }
                result[id - 1][1] = sum / 5;
                i = i + 4;
            }
        }
        return result;
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
        System.out.println(restoreString("aiohn", new int[]{3,1,4,2,0}));

    }
}
