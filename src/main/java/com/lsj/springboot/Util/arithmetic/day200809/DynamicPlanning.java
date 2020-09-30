package com.lsj.springboot.Util.arithmetic.day200809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

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
 * 题目309:最佳买卖股票时机含冷冻期
 *
 * 714. 买卖股票的最佳时机含手续费
 *
 *  64. 最小路径和
 *
 *  256.粉刷房子
 *
 *  题目96:不同的二叉搜索树
 *
 *  120. 三角形最小路径和
 *
 *  62. 不同路径
 *
 *  300. 最长上升子序列
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
     * 剑指 Offer 63. 股票的最大利润
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。注意：你不能在买入股票前卖出股票。
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
     * 309. 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 输入: [1,2,3,0,2]  输出: 3   解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * 输入: [1,2,10,0,2]  输出: 9   解释: 对应的交易状态为: [买入, 持有, 卖出, 冷冻期, 买入]
     * @param prices
     * @return
     */
/*  我们用 f[i] 表示第 i 天结束之后的「累计最大收益」。根据题目描述，由于我们最多只能同时买入（持有）一支股票，并且卖出股票后有冷冻期的限制，因此我们会有三种不同的状态：
    我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
    我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][1]；
    我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。

    如何进行状态转移呢？在第 i 天时，我们可以在不违反规则的前提下进行「买入」或者「卖出」操作，此时第 i 天的状态会从第 i-1 天的状态转移而来；
    我们也可以不进行任何操作，此时第 i 天的状态就等同于第 i-1 天的状态。那么我们分别对这三种状态进行分析：
    1.对于 f[i][0]，我们目前持有的这一支股票可以是在第 i-1 天就已经持有的，对应的状态为 f[i−1][0]；或者是第 i 天买入的，那么第 i-1 天就不能持有股票并且不处于冷冻期中，对应的状态为 f[i-1][2] 加上买入股票的负收益 prices[i]。因此状态转移方程为：
        f[i][0]=max(f[i−1][0],f[i−1][2]−prices[i])
    2.对于 f[i][1]，我们在第 i 天不处于冷冻期的原因是在当天卖出了股票，那么说明在第 i-1 天时我们必须持有一支股票，对应的状态为 f[i-1][0] 加上卖出股票的正收益prices[i]。因此状态转移方程为：
        f[i][1]=f[i−1][0]+prices[i]
    3.对于 f[i][2]，我们在第 i 天不持有任何股票并且处于冷冻期，说明当天没有进行任何操作，即第 i-1 天时不持有任何股票：如果处于冷冻期，对应的状态为 f[i-1][1]；如果不处于冷冻期，对应的状态为 f[i-1][2]。因此状态转移方程为：
        f[i][2]=max(f[i−1][1],f[i−1][2])
    4.这样我们就得到了所有的状态转移方程。如果一共有 n 天，那么最终的答案即为：max(f[n−1][0],f[n−1][1],f[n−1][2])
    5.注意到如果在最后一天（第 n-1 天）结束之后，手上仍然持有股票，那么显然是没有任何意义的。因此更加精确地，最终的答案实际上是 f[n-1][1] 和 f[n-1][2] 中的较大值，即：max(f[n−1][1],f[n−1][2])

    我们可以将第 0 天的情况作为动态规划中的边界条件：f[0][0] = −prices[0]   f[0][1] = 0   f[0][2] = 0*/

    /*注意到上面的状态转移方程中，f[i][..] 只与f[i−1][..] 有关，
    而与 f[i−2][..] 及之前的所有状态都无关，因此我们不必存储这些无关的状态。也就是说，我们只需要将 f[i−1][0]，f[i−1][1]，f[i−1][2] 存放在三个变量中，
    通过它们计算出 f[i][0]，f[i][1]，f[i][2] 并存回对应的变量。*/
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            // 当天持有股票的2种情况：1.连续持有；2.买入(上一天不持有，在冷冻期)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 当天不持有股票、不在冷冻期的情况：1.上一天持有，当天卖出
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 当天不持有股票、在冷冻期的情况：1.上一天不持有且卖出;1.上一天不持有且处于冷冻期
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * 输入: prices = [1, 3, 2, 8, 3, 9], fee = 2         输出: 9
     * 解释: 能够达到的最大利润: 在此处买入 prices[0] = 1;在此处卖出 prices[3] = 8;在此处买入 prices[4] = 3;在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 3) - 2) = 9.
     * @param prices
     * @param fee
     * @return
     */

    /*我们维护两个变量cash 和 hold，前者表示当我们不持有股票时的最大利润，后者表示当我们持有股票时的最大利润。
    在第 i 天时，我们需要根据第 i−1 天的状态来更新 cash 和 hold 的值。对于 cash，我们可以保持不变，或者将手上的股票卖出，状态转移方程为
            cash = max(cash, hold + prices[i] - fee)
    对于hold，我们可以保持不变，或者买入这一天的股票，状态转移方程为
            hold = max(hold, cash - prices[i])*/
    public int maxProfit3(int[] prices, int fee) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int cash = 0;
        int hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int cash0 = Math.max(cash, hold + prices[i] - fee);
            int hold0 = Math.max(hold, cash - prices[i]);
            cash= cash0;
            hold = hold0;
        }
        return Math.max(cash, hold);
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
     * 256.粉刷房子
     * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
     * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。
     * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。注意：所有花费均为正整数。
     * [[17,2,17],
     * [16,16,5],
     * [14,3,19]]
     * 输出: 10
     * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。最少花费: 2 + 5 + 3 = 10。(红蓝绿)注：红蓝绿不能连续出现
     * @param costs
     * @return
     */
    public static int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0){
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        for(int i = 0; i < costs.length; i++){
            if(i == 0){
                for(int j = 0; j < costs[0].length; j++){
                    dp[0][j] = costs[0][j];
                }
            }else{
                for(int j = 0; j < costs[i].length; j++){
                    int minValue = Integer.MAX_VALUE;
                    for(int k = 0; k < costs[i].length; k++){
                        if(k != j) {
                            minValue = Math.min(costs[i][j] + dp[i - 1][k], minValue);
                        }
                    }
                    dp[i][j] = minValue;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < costs[0].length; i++){
            res = Math.min(res, dp[costs.length - 1][i]);
        }
        return res;
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

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 例如，给定三角形：
     * [     [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0){
            return 0;
        }
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                }else if(j == triangle.get(i).size() - 1){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                }else{
                    triangle.get(i).set(j, triangle.get(i).get(j) +
                            Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                }
            }
        }

        if(triangle.size() > 0){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++){
                min = Math.min(min, triangle.get(triangle.size() - 1).get(i));
            }
            return min;
        }else{
            return triangle.get(0).get(0);
        }
    }

    /**
     * 62. 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。问总共有多少条不同的路径？
     * 输入: m = 3, n = 2     输出: 3
     * 解释:从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下      2. 向右 -> 向下 -> 向右     3. 向下 -> 向右 -> 向右
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }else if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 300. 最长上升子序列
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * 输入: [10,9,2,5,3,7,101,18]    输出: 4   解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];// 记录每个点的最长上升子序列
        dp[0] = 1;
        int ans = dp[0];
        for(int i = 1; i < nums.length; i++){
            int maxValue = 0;// 记录max(dp[0…i−1])
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + 1;// dp[i]被选取
            // dp[i] = max(dp[0…i−1]) + 1
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

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
        System.out.println(minCost(costs));
       /* List<Integer> param1 = new ArrayList(){{add(2);}};
        List<Integer> param2 = new ArrayList(){{add(3);add(4);}};
        List<Integer> param3 = new ArrayList(){{add(6);add(5);add(7);}};
        List<Integer> param4 = new ArrayList(){{add(4);add(1);add(8);add(3);}};
        List<List<Integer>> params = new ArrayList(){{add(param1);add(param2);add(param3);add(param4);}};
        System.out.println(minimumTotal(params));*/
//        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
