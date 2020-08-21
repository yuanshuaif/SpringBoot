package com.lsj.springboot.Util.arithmetic.day200812;

/**
 *  1491. 去掉最低工资和最高工资后的工资平均值
 *
 *  剑指 Offer 42. 连续子数组的最大和(同53. 最大子序和)
 *
 *  922. 按奇偶排序数组 II
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

    public static void main(String[] args){
        System.out.println(sortArrayByParityII(new int[]{4,2,5,6,9,7}));
    }
}
