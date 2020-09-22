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
 * （剑指 Offer 10- II. 青蛙跳台阶问题、剑指 Offer 10- I. 斐波那契数列）
 * 递归、迭代、动态规划
 *
 * 1137. 第 N 个泰波那契数
 *
 *  题目392： 判断子序列
 *  入栈法
 *
 *  题目121：买卖股票的最佳时机
 *
 *  64. 最小路径和
 *
 *  粉刷房子的问题
 *
 *  题目96:不同的二叉搜索树
 *
 */
public class DynamicPlanning {

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

    /**
     * 1137. 第 N 个泰波那契数
     * 泰波那契序列 Tn 定义如下： T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     * 输入：n = 4 输出：4    解释：T_3 = 0 + 1 + 1 = 2  T_4 = 1 + 1 + 2 = 4
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        int cur = 0;
        for(int i = 3; i <= n; i++){
            cur = first + second + third;
            first = second;
            second = third;
            third = cur;
        }
        return cur;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * 注意：你不能在买入股票前卖出股票。
     * 输入: [7,1,5,3,6,4]            输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 输入: [7,6,4,3,1]              输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 动态规划：1.记录历史最低价格，2.记录当天收益=当前价格-历史最低价格，3.取每天的最大值
        int minValue = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minValue){
                minValue = prices[i];// 历史最低点买
            }else{
                if(prices[i] - minValue > ans){
                    ans = prices[i] - minValue;
                }
//                ans = Math.max(ans, prices[i] - minValue);// 当天收益
            }
        }
        return ans;
    }

    /**
     * 64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。说明：每次只能向下或者向右移动一步。
     * 输入:[[1,3,1],[1,5,1],[4,2,1]]     输出: 7        解释: 因为路径 1→3→1→1→1 的总和最小。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0] == null){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }else if(j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
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
     * 96. 不同的二叉搜索树
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * 输入: 3        输出: 5
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }
}
