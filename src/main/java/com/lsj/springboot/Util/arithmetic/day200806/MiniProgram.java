package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.Arrays;

/**
 * 344. 反转字符串
 * 双指针
 */
public class MiniProgram {

    public static void main(String[] args){
        int[][] costs = new int[3][3];
        costs[0][0] = 17;
        costs[0][1] = 2;
        costs[0][2] = 17;

        costs[1][0] = 16;
        costs[1][1] = 16;
        costs[1][2] = 5;

        costs[2][0] = 14;
        costs[2][1] = 3;
        costs[2][2] = 19;
//         [[3,5,3],[6,17,6],[7,13,18],[9,10,18]]

        System.out.println(minCost(costs));
    }

    /**
     * 粉刷房子的问题
     * 输入: [[17,2,17],[16,16,5],[14,3,19]]     [[3,5,3],[6,17,6],[7,13,18],[9,10,18]]
     * 输出: 10   26
     * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。最少花费: 2 + 5 + 3 = 10。(红蓝绿)
     * 注：红蓝绿不能连续出现
     * @param costs
     * @return
     */
    public static int minCost(int[][] costs) {
//        int min = 0;
//        if(costs.length == 0) return min;
//        for(int i = 0; i < costs.length; i++){
//            int minTemp = costs[i].length == 0 ? 0 : costs[i][0];
//            for(int j = 0; j < costs[i].length; j++){
//                minTemp = Math.min(minTemp, costs[i][j]);
//            }
//            min += minTemp;
//        }
//        return min;
        return 0;
    }


    /**
     * 344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。  你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * 输入：["h","e","l","l","o"]  输出：["o","l","l","e","h"]
     * 输入：["H","a","n","n","a","h"]  输出：["h","a","n","n","a","H"]
     *
     * @param s
     */
    public char[] reverseString(char[] s) {
        char temp;
        for(int i = 0; i < s.length / 2; i++){
            temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return s;
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
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
}


