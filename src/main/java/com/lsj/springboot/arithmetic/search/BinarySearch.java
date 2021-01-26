package com.lsj.springboot.arithmetic.search;

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
 * 面试题 10.09. 排序矩阵查找
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
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 1351. 统计有序矩阵中的负数
 *
 * 1064. 不动点 （魔术索引的简单版）
 *
 * 441. 排列硬币
 *
 * 剑指 Offer 11. 旋转数组的最小数字
 * 154. 寻找旋转排序数组中的最小值 II
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
     * 面试题 10.09. 排序矩阵查找
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
     * 假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
     *
     * 输入：nums = [2,4,5,5,5,5,5,6,6], target = 5    输出：true   [2,4,5,5,5,5,5,6]
     * 解释：数字 5 出现了 5 次，而数组的长度为 9。所以，5 在数组中占绝大多数，因为 5 次 > 9/2。
     * 输入：nums = [10,100,101,101], target = 101     输出：false
     * 解释：数字 101 出现了 2 次，而数组的长度是 4。所以，101 不是 数组占绝大多数的元素，因为 2 次 = 4/2。
     *
     * 核心算法：1.中间位置不是查找的元素直接返回；2.分成左右2个区间，查找左边的第一个元素，跟右边的最后一个元素；3.元素总个数 * 2 <= length 返回false
     * @param nums
     * @param target
     * @return
     */
    public static boolean isMajorityElement(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = 0;
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
                    startIndex = mid;
                    leftEnd = mid - 1;
                }
            }
            while(rightStart <= end){
                mid = (rightStart + end) / 2;
                if(nums[mid] > target){
                    end = mid - 1;
                }else if(nums[mid] == target){
                    endIndex = mid;
                    rightStart = mid + 1;
                }
            }
            if(((endIndex - startIndex + 1) << 1) <= nums.length){
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
            // 1.左边第一个不为空的字符
            while(start <= end && words[start].length() == 0){
                start++;
            }
            // 2.右边第一个不为空的字符
            while(start <= end && words[end].length() == 0){
                end--;
            }
            // 3.找到不为空的中间字符
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
        int start = 1;
        int end = arr.length - 2;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
                return mid;
            }else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }else if(arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]){
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 面试题 08.03. 魔术索引
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
     * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * 输入：nums = [0, 2, 3, 4, 5]   输出：0    说明: 0下标的元素为0             输入：nums = [0, 0，2]   输出：0
     * 核心算法：左中右的顺序判断是否有满足条件 （左右需要递归）
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
     * 核心算法：先使用二分查找找出在哪一行里，再使用二分查找找出在哪一列里    也可以使用：240. 搜索二维矩阵的算法
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

    /**
     * 153. 寻找旋转排序数组中的最小值
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 请找出其中最小的元素。你可以假设数组中不存在重复元素。
     * 输入: [3,4,5,1,2]  输出: 1
     * 输入: [4,5,6,7,0,1,2]  输出: 0
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int mid;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            mid = (start + end) / 2;
            if(nums[mid] >= nums[0]){// = [2,1]
                start = mid + 1;
            }else if(nums[mid] > nums[mid - 1]){
                end = mid - 1;
            }else{
                return nums[mid];
            }
        }
        return nums[0];
    }

    /**
     * 1351. 统计有序矩阵中的负数
     * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。请你统计并返回 grid 中 负数 的数目。
     * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]  输出：8   解释：矩阵中共有 8 个负数。
     * 输入：grid = [[3,2],[1,0]]  输出：0        输入：grid = [[1,-1],[-1,-1]]   输出：3
     * [[3,2],[-3,-3],[-3,-3],[-3,-3]]
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = 0;
        int col = grid[0].length - 1;
        int len = 0;
        int ans = 0;
        while(col >= 0 && row <= grid.length - 1){
            if(grid[row][col] < 0){
                col--;
                len++;
            }else{
                ans += len * (grid.length - row);
                row++;
                len = 0;
            }
        }
        return len > 0 ? (len * (grid.length - row)  + ans) : ans;
    }

    /**
     * 1064. 不动点
     * 给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
     * 输入：[-10,-5,0,3,7]    输出：3    解释：对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
     * 输入：[0,2,5,8,17]      输出：0    示例：A[0] = 0，因此输出为 0 。
     * 输入：[-10,-5,3,4,7,9]  输出：-1   解释：不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
     * 与面试题 08.03. 魔术索引的区别为该题中的元素不重复
     * @param A
     * @return
     */
    public static int fixedPoint(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(mid == A[mid]){
                ans = mid;
                end = mid - 1;
            }else if(mid < A[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 441. 排列硬币
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     * n = 8    因为第四行不完整，所以返回3.
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        // long ans = 0;
        // int i = 1;
        // while(ans < n){
        //     ans += i++;
        // }
        // return ans == n ? i - 1 : i  - 2;

        // 行数和硬 币数有如下对应关系：
        // [ 1, 2, 3, 4,......,n]
        // [ 1, 3, 6, 10,...... ((n+1)×n)/2]
        int start = 1;
        int end = n;
        while(start <= end){
            long mid = start + (end - start) / 2;// 行数
            long multiply = (mid + 1) * mid / 2;
            if(multiply == n){
                return (int)mid;
            }else if(multiply < n){
                start = (int)mid + 1;
            }else{
                end = (int)mid - 1;
            }
        }
        return end;
    }

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * 154. 寻找旋转排序数组中的最小值 II
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 输入：[3,4,5,1,2]       输出：1
     * 输入：[2,2,2,0,1]       输出：0
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {//舍弃右边部分
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {// 舍弃左边部分(自身也可舍弃)
                low = pivot + 1;
            } else {
                // 此时不能确定在最小值的左边还是右边，不能舍弃某一边；因为numbers[pivot] == numbers[high]，
                // 所以舍弃numbers[high]不会有什么影响，重新进行二分搜索
                high--;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args){
//        System.out.println(isMajorityElement(new int[]{1,2,3,4,5}, 3));
//        System.out.println(minArray(new int[]{10,1,10,10,10}));
        System.out.println(fixedPoint(new int[]{0, 0, 2}));
    }
}
