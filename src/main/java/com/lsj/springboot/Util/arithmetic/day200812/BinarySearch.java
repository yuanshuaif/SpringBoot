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
 * 367. 有效的完全平方数(类似于69题)
 *
 * 240. 搜索二维矩阵 II(剑指 Offer 04. 二维数组中的查找)
 *
 * 1150. 检查一个数是否在数组中占绝大多数
 *
 * 面试题 10.05. 稀疏数组搜索
 *
 * 852. 山脉数组的峰顶索引
 *
 * 面试题 08.03. 魔术索引
 *
 * 74. 搜索二维矩阵
 */
public class BinarySearch {

    private static int[] list = new int[]{8,5,12,98,53,22,65,21,75,89,32,21};

    public static int searchZreo(int[] array, int value){
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == value) {
                return value;
            } else if (array[mid] > value) {
                end = mid - 1;
            } else if (array[mid] < value) {
                start = mid + 1;
            }
        }
        return -1;
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

    /**
     * 240. 搜索二维矩阵 II(剑指 Offer 04. 二维数组中的查找)
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。  每列的元素从上到下升序排列。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        // 二维数组的二分查找，从右上角开始向左减小，向右增大
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > target){
                col--;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 1150. 检查一个数是否在数组中占绝大多数
     * 给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。
     * 假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
     * 所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
     *
     * 输入：nums = [2,4,5,5,5,5,5,6,6], target = 5    输出：true
     * [2,4,5,5,5,5,5,6]
     * 解释：数字 5 出现了 5 次，而数组的长度为 9。所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
     *
     * 输入：nums = [10,100,101,101], target = 101     输出：false
     * 解释：数字 101 出现了 2 次，而数组的长度是 4。所以，101 不是 数组占绝大多数的元素，因为 2 次 = 4/2。
     * @param nums
     * @param target
     * @return
     */
    public static boolean isMajorityElement(int[] nums, int target) {
        int start0 = 0;
        int end0 = 0;
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        if(nums[mid] != target){
            return false;
        }else{
            int leftEnd = mid;
            int rightStart = mid;
            while(start <= leftEnd){// == 解决[101,101]
                mid = (start + leftEnd) / 2;
                if(nums[mid] < target){
                    start = mid + 1;
                }else if(nums[mid] == target){
                    start0 = mid;
                    leftEnd = mid - 1;
                }
            }
            while(rightStart <= end){
                mid = (rightStart + end) / 2;
                if(nums[mid] > target){
                    end = mid - 1;
                }else if(nums[mid] == target){
                    end0 = mid;
                    rightStart = mid + 1;
                }
            }
            if(((end0 - start0 + 1) << 1) <= nums.length){
                return false;
            }
        }
        return true;
    }

    /**
     * 面试题 10.05. 稀疏数组搜索
     * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
     * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"       输出：-1   说明: 不存在返回-1。
     * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"     输出：4
     * @param words
     * @param s
     * @return
     */
    public int findString(String[] words, String s) {
        int start = 0;
        int end = words.length - 1;
        while(start <= end){
            // 左边第一个不为空的字符
            while(start <= end && words[start].length() == 0){
                start++;
            }
            // 右边第一个不为空的字符
            while(start <= end && words[end].length() == 0){
                end--;
            }
            // 找到不为空的中间字符
            int mid = (start + end) / 2;
            while(mid >= start && words[mid].length() == 0){
                mid--;
            }
            if(words[mid].compareTo(s) > 0){
                end = mid - 1;
            }else if(words[mid].compareTo(s) < 0){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 852. 山脉数组的峰顶索引
     * 我们把符合下列属性的数组 A 称作山脉：A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * 输入：[0,1,0]   输出：1        输入：[0,2,1,0] 输出：1
     * 3 <= A.length <= 10000   0 <= A[i] <= 10^6   A 是如上定义的山脉(即不考虑边界问题)
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
                return mid;
            }else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }else if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]){
                // [3,5,3,2,0]  end = mid - 1;
                end = mid;
            }
        }
        return -1;
    }

    /**
     * 面试题 08.03. 魔术索引
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
     * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     *  输入：nums = [0, 2, 3, 4, 5]   输出：0    说明: 0下标的元素为0
     *  输入：nums = [0, 0，2]   输出：0
     * @param nums
     * @return
     */
    public static int findMagicIndex(int[] nums) {
        return findMagicIndex(nums, 0, nums.length - 1);
    }

    public static int findMagicIndex(int[] nums, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        int left = findMagicIndex(nums, start, mid - 1);
        if(left != -1){
            return left;
        }else if(mid == nums[mid]){
            return mid;
        }
        return findMagicIndex(nums, mid + 1, end);
    }

    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
     * 输入:matrix = [[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]] target = 3  输出: true
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix0(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int len = matrix[0].length;
        int first = 0;
        int last = matrix.length - 1;
        int cur = -1;
        while(first <= last){
            int mid = (first + last) / 2;
            if(matrix[mid][0] > target){
                last = mid - 1;
            }else if(matrix[mid][len - 1] < target){
                first = mid + 1;
            }else{
                cur = mid;
                break;
            }
        }
        if(cur == -1){
            return false;
        }else{
            int start = 0;
            int end = matrix[0].length - 1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(matrix[cur][mid] > target){
                    end = mid - 1;
                }else if(matrix[cur][mid] < target){
                    start = mid + 1;
                }else{
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
//        System.out.println(isMajorityElement(new int[]{1,2,3,4,5}, 3));
        System.out.println(findMagicIndex(new int[]{0,0,2}));
    }
}
