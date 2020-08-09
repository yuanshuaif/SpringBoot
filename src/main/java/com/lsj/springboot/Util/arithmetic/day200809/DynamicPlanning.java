package com.lsj.springboot.Util.arithmetic.day200809;

import java.util.Stack;

/**
 * Created by 10326 on 2020/8/9.
 * 动态规划
 *
 * 题目5：最长回文子串
 * 滑动窗口、动态规划
 *
 * 题目53: 最大子序和
 *
 * 题目70：爬楼梯
 * 递归、迭代、动态规划
 *
 *  题目392： 判断子序列
 *  入栈法
 *
 */
public class DynamicPlanning {
    /**
     * 题目5：最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
     * 输入 babad 输出 bab或者aba
     * 输入 abbd 输出 bb
     * @param str
     * @return
     */
    public static String longestPalindromeStr(String str){
        // 耗时17毫秒   滑动窗口
       /* long startTime = System.currentTimeMillis();
        String palindromeStr = "";
        char[] chars = str.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len; i++){
            int start = 0;
            int end = len - i;
            while(end <= str.length()) {
                if(isPalindromeStr(chars, start, end - 1)){
                    palindromeStr = str.substring(start, end);
                    break;
                }
                start++;
                end++;
            }
            if(!StringUtils.isEmpty(palindromeStr)){
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return palindromeStr; */

        // 动态规划(效果可能不如滑动窗口   思想很重要)
        int len = str.length();
        // 1.特殊值处理
        if(len < 2){
            return str;
        }
        // 2.初始化对角线的值
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        int start = 0;
        int maxlength = 1;
        // 3.循环矩阵的上半部分
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                // 4.核心算法
                //如果s[i]==s[j]那么说明只要dp[i+1][j-1]是回文子串，那么是dp[i][j]也就是回文子串
                //如果s[i]=/s[j]那么说明dp[i][j]必定不是回文子串。
                if(str.charAt(i) != str.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j - i == 1){//2数之间没有元素时，视为基值
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxlength){// j - i + 1: 标识回文子串的长度
                    maxlength = j - i + 1;
                    start = i;
                }
            }
        }
        return str.substring(start, start + maxlength);
    }

    private static boolean isPalindromeStr(char[] chars, int start, int end){
        while(start < end){
            if(chars[start] != chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]  输出: 6    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
//        动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
//        如果 hsum > 0，则说明 hsum 对结果有增益效果，则 sum 保留并加上当前遍历数字
//        如果 hsum <= 0，则说明 hsum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
//        每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果       时间复杂度：O(n)
        int hSum = 0;// 历史和
        int sum = 0;// 当前和
        int ans = nums[0];// 最大和
        for(int num : nums){
            if(hSum <= 0){
                sum = num;
            }else{
                sum = hSum + num;
            }
            hSum = sum;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * 70.爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
        爬上 n-1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
        爬上 n-2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
        所以我们得到公式 dp[n] = dp[n-1] + dp[n-2] ； 同时需要初始化 dp[0]=1d 和 dp[1]=1
     * 类似于斐波那契数
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n < 2)  return n;
        // 初始化
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;
        for(int i = 2; i <= n; i++){
            ints[i] = ints[i - 2] + ints[i - 1];
        }
        return ints[n];
    }

    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
        你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
        字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
        示例 1:s = "abc", t = "ahbgdc"    返回 true.    示例 2:s = "axc", t = "ahbgdc" 返回 false.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        // 入栈法 将t字节压入到栈里，取出来与s的字节匹配，
        // 若结束后，s字节没有值是子序列，若有值不是子序列
        Stack<Character> st =new Stack<>();
        for(char ch : t.toCharArray()){
            st.push(ch);
        }
        int compile = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(!st.isEmpty()){
                char pop = st.pop();
                while(!st.isEmpty() && s.charAt(i) != pop){
                    pop = st.pop();
                }
                if(s.charAt(i) == pop){
                    compile++;
                }
            }
        }
        return compile == s.length();
    }

}
