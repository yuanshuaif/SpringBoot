package com.lsj.springboot.Util.arithmetic.day200818;

import java.util.Arrays;

/**
 * 判断一个数是否是质数
 *
 *  169. 多数元素
 */
public class Maths {

    // 判断一个数是否是质数
    public static boolean isPrime(int src) {
        double sqrt = Math.sqrt(src);
        if (src < 2) {
            return false;
        }
        if (src == 2 || src == 3) {
            return true;
        }
        if (src % 2 == 0) {// 先判断是否为偶数，若偶数就直接结束程序
            return false;
        }
        for (int i = 3; i <= sqrt; i += 2) {
            if (src % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 169. 多数元素
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 输入: [2,2,1,1,1,2,2]  输出: 2
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
