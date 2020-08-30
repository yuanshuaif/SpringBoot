package com.lsj.springboot.Util.arithmetic.day200812;

import java.util.Arrays;

/**
 *  1491. 去掉最低工资和最高工资后的工资平均值
 *
 *  剑指 Offer 42. 连续子数组的最大和(同53. 最大子序和)
 *
 *  922. 按奇偶排序数组 II
 *
 *  252. 会议室
 *
 *  976. 三角形的最大周长
 *
 *  56. 合并区间
 *
 *  面试题 17.14. 最小K个数
 *
 */
public class Sort {
    /**
     * 1491. 去掉最低工资和最高工资后的工资平均值
     * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
     * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
     * 输入：salary = [4000,3000,1000,2000]    输出：2500.00000
     * 解释：最低工资和最高工资分别是 1000 和 4000 。去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        double nums = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : salary){
            nums += num;
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return (nums - max - min) / (salary.length - 2);
    }

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]   输出: 6   解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 动态规划时间复杂度O(n)  分治算法时间复杂度O(nlogn)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //分治算法 分而治之，归并子集
        return maxSubArrayDivideWithBroder(nums, 0, nums.length - 1);
    }

    public int maxSubArrayDivideWithBroder(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int center = (start + end) / 2;
        int left = maxSubArrayDivideWithBroder(nums, start, center);
        int right = maxSubArrayDivideWithBroder(nums, center + 1, end);

        int ansSubLeft = nums[center];
        int sumSubLeft = 0;
        for(int i = center; i >= start; i--){
            sumSubLeft += nums[i];
            ansSubLeft = Math.max(ansSubLeft, sumSubLeft);
        }
        int ansSubRight = nums[center + 1];
        int sumSubRight = 0;
        for(int i = center + 1; i <= end; i++){
            sumSubRight += nums[i];
            ansSubRight = Math.max(sumSubRight, ansSubRight);
        }
        int sumSub = ansSubLeft + ansSubRight;
        return Math.max(sumSub, Math.max(left, right));
    }

    /**
     * 922. 按奇偶排序数组 II
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * 你可以返回任何满足上述条件的数组作为答案
     * 输入：[4,2,5,7]     输出：[4,5,2,7]    解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     * 2 <= A.length <= 20000       A.length % 2 == 0       0 <= A[i] <= 1000
     *
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        int temp = 0;
        int j = 1;
        for(int i = 0; i < A.length; i = i + 2){
            if(A[i] % 2 == 1){// 偶数位如果是奇数
                for(; i < A.length; j = j + 2){
                    if(A[j] % 2 != 1){// 奇数位如果是偶数
                        temp = A[j];
                        A[j] = A[i];
                        A[i] = temp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    /**
     * 252. 会议室
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
     * 输入: [[0,30],[5,10],[15,20]]   输出: false
     * 输入: [[7,10],[2,4]]   输出: true
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);// 对第一列进行排序
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i][1] > intervals[i + 1][0]){
                return false;
            }
        }
        return true;
    }

    /**
     * 976. 三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * 输入：[2,1,2]   输出：5                输入：[1,2,1]    输出：0
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        //形成三角形的前提：2边之和大于第3边
        Arrays.sort(A);
        for(int i = A.length -1; i >= 2; i--){
            if(A[i] < A[i - 1] + A[i - 2]){
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    /**
     * 56. 合并区间
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]     输出: [[1,6],[8,10],[15,18]]
     * 输入: intervals = [[1,4],[4,5]]    输出: [[1,5]]
     * 输入: intervals = [[1,4],[2,3],[4,5],[6,7]]    输出: [[1,5]],[6,7]]
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // [[1,4],[2,3],[4,5],[6,7]]
        // [[1,3],[2,6],[8,10],[15,18]]
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        int[][] ans = new int[intervals.length][2];
        int start = 0;
        int end = 0;
        int cur = 0;// 返回结果指针
        boolean flag = false;
        for(int i = 0; i < intervals.length; i++){
            end = Math.max(intervals[i][1], end);
            if(i != intervals.length - 1){
                if(end < intervals[i + 1][0]){
                    ans[cur][0] = flag ? start : intervals[i][0];
                    ans[cur][1] = end;
                    cur++;
                    start = 0;
                    flag = false;
                }else{
                    if(!flag){
                        start = intervals[i][0];
                        flag = true;
                    }
                }
            }else{
                ans[cur][0] = flag ? start : intervals[i][0];
                ans[cur][1] = end;
            }
        }
        return Arrays.copyOfRange(ans, 0, cur + 1);
    }

    /**
     * 面试题 17.14. 最小K个数
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     * 示例：输入： arr = [1,3,5,7,2,4,6,8], k = 4    输出： [1,2,3,4]
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        sort(arr, 0, arr.length - 1);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = arr[i];
        }
        return ans;
    }
    public void sort(int[] arr, int left, int right){
        if(arr.length == 0){
            return;
        }
        int fLeft = left;
        int fRight = right;
        int x = arr[left];
        while(fLeft < fRight){
            while(fLeft < fRight && arr[fRight] >= x){
                fRight--;
            }
            if(fLeft < fRight){
                arr[fLeft++] = arr[fRight];
            }
            while(fLeft < fRight && arr[fLeft] < x){
                fLeft++;
            }
            if(fLeft < fRight){
                arr[fRight--] = arr[fLeft];
            }
        }
        arr[fLeft] = x;// fLeft == fRight
        if(left < fLeft){
            sort(arr, left, fLeft - 1);
        }
        if(right > fRight){
            sort(arr, fRight + 1, right);
        }
    }

    public static void main(String[] args){
        System.out.println(sortArrayByParityII(new int[]{4,2,5,6,9,7}));
    }
}
