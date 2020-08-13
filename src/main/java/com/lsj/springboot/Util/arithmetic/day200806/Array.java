package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目1:2数之和
 *
 * 题目26:删除排序数组中的重复项
 * 双指针
 *
 * 题目88(10.01):合并排序的数组
 * 利用归并排序进行merge
 *
 * 题目27:移除元素（同26）
 * 双指针
 *
 * 题目485:最大连续1的个数
 *
 * 题目15:三数之和
 *
 * 题目11:盛最多水的容器
 * 双指针
 *
 * 题目495:中毒总时长
 *
 * 题目21:合并两个有序链表（数组）
 *
 * 题目605:种花问题
 *
 * 题目283:移动零
 * 双指针
 *
 * 题目125:验证回文串
 * 双指针
 *
 * 977. 有序数组的平方
 * 双指针
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
        int[] A = new int[]{-4,-1,0,3,10};
        System.out.println(sortedSquares(A));

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
     * 26.删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复的数组，使得每一个元素只出现一次，返回新数组的长度
     * 不要使用额外的数组空间，并在原地修改输入数组  元素的顺序可以改变        nums{0,0,1,1,1,2,2,3,3,4}
     * @param original
     * @return
     */
    private static int deleteCommonItem(Integer[] original){
        if(original == null){
            return 0;
        }else if(original.length < 2){
            return original.length;
        }
        int cur = 0;
        for(int i = 1; i < original.length; i++){
            if(original[cur] != original[i]){
                original[++cur] = original[i];
            }
        }
        return (cur + 1);
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
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 输入: nums1 = [1,2,3,0,0,0], m = 3   nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge88(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m); // [0,0,0,1,2,3]
        int index1 = n, index2 = 0;
        int index = 0;
        while (index1 < n + m && index2 < n){
            if(nums1[index1] > nums2[index2]){
                nums1[index++] = nums2[index2++];
            }else if(nums1[index1] < nums2[index2]){
                nums1[index++] = nums1[index1++];
            }else{
                nums1[index++] = nums1[index1++];
                nums1[index++] = nums2[index2++];
            }
        }
        while (index2 < n){
            nums1[index++] = nums2[index2++];
        }
        while (index1 < n + m){
            nums1[index++] = nums1[index1++];
        }
    }

    /**
     * 27.移除元素(思路同删除重复项)
     * 给定一个排序数组nums和一个值val，你需要在原地删除值等于val的元素，返回新数组的长度
     * 不要使用额外的数组空间，并在原地修改输入数组 元素的顺序可以改变         nums{3,2,3,1,4,5,3,2,1}
     * @param original
     * @return
     */
    private static int deleteAssignItem(Integer[] original, int target){
        if(original == null){
            return 0;
        }
        int cur = 0;
        for(int i = 0; i < original.length; i++){
            if(original[i] != target){
                original[cur++] = original[i];
            }
        }
        return cur;
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
     * 题目11:盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     说明：你不能倾斜容器，且 n 的值至少为 2。
     输入：[1,8,6,2,5,4,8,3,7] 输出：49
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 双指针
        int start = 0;
        int end = height.length - 1;
        int maxCatacity = 0;
        while(start < end){
            int wide = end - start;// 桶的宽
            int minHeight = Math.min(height[start], height[end]);// 桶单的最小高
            maxCatacity = Math.max(maxCatacity, wide * minHeight);
            // 移动小的边
            if(minHeight == height[start]){
                start++;
            }else{
                end--;
            }
        }
        return maxCatacity;
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
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 输入: [0,1,0,3,12]     输出: [1,3,12,0,0]
     * 1.必须在原数组上操作，不能拷贝额外的数组。2.尽量减少操作次数。
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int cur = 0;
        int len = 0;
        for(; len < nums.length; len++){
            if(nums[len] != 0){
                nums[cur++] = nums[len];
            }
        }
        for(int j = cur; j < len; j++){
            nums[j] = 0;
        }
        System.out.println(nums);
    }

    /**
     * 125. 验证回文串
     *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 输入: "A man, a plan, a canal: Panama" 输出: true
     * 输入: "race a car" 输出: false
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;

    }

    /**
     * 977. 有序数组的平方
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * [-4,-1,0,3,10] [-7,-3,2,3,11] [-7,-3,2,8,11]
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int[] result = new int[A.length];
        int cur = A.length - 1;
        while(start < end){
            if(A[start] * A[start] < A[end] * A[end]){
                result[cur--] = A[end] * A[end];
                end--;
            }else if(A[start] * A[start] > A[end] * A[end]){
                result[cur--] = A[start] * A[start];
                start++;
            }else{
                result[cur--] = A[end] * A[end];
                result[cur--] = A[start] * A[start];
                start++;
                end--;
            }
        }
        if(start == end){
            result[0] = A[start] * A[start];
        }
        return result;
    }

}
