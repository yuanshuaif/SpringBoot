package com.lsj.springboot.Util.arithmetic.day200809;

import java.util.Arrays;
import java.util.List;
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
 *  198. 打家劫舍
 *
 * 300. 最长上升子序列
 *
 * LCP 19. 秋叶收藏集
 *
 * 面试题 08.01. 三步问题
 *
 * 279. 完全平方数
 *
 * 746. 使用最小花费爬楼梯
 *
 * 542. 01 矩阵
 *
 * 845. 数组中的最长山脉
 *
 * 718. 最长重复子数组
 *
 * 238. 除自身以外数组的乘积
 *
 * 面试题 17.16. 按摩师
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
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 输入：[2,7,9,3,1]       输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if(length == 1){
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[length - 1];
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

    /**
     * LCP 19. 秋叶收藏集
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y，
     * 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。
     * 每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
     * 请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。 leaves 中只包含字符 'r' 和字符 'y'
     * 输入：leaves = "rrryyyrryyyrr"      输出：2        解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
     * 输入：leaves = "ryr"                输出：0        解释：已符合要求，不需要额外操作
     * @param leaves
     * @return
     */
    /*由于我们想要将收藏集中树叶的排列调整成「红、黄、红」三部分，因此我们可以用 3 个状态分别表示其中的每一部分，即状态 0 和状态 2 分别表示前面和后面的红色部分，状态 1 表示黄色部分。
    此时，我们就可以尝试使用动态规划解决本题了。我们用 f[i][j] 表示对于第 0 片到第 i 片叶子（记为 leaves[0..i]）进行调整操作，并且第 i 片叶子处于状态 j 时的最小操作次数。在推导状态转移方程时，我们可以分别对于每一种状态进行分析。
    当 j=0时，我们需要将第 i 片叶子变成红色，并且第 i-1 片叶子也只能处于 j=0的状态（因为没有编号更小的状态了），因此有状态转移方程：
    f[i][0]=f[i−1][0]+isYellow(i)
    当 j=1 时，我们需要将第 i 片叶子变成黄色，而第 i-1 片叶子既可以处于 j=1 的状态，也可以处于 j=0 的状态，我们选择其中的较小值，因此有状态转移方程：
    f[i][1]=min{f[i−1][0],f[i−1][1]}+isRed(i)
    当 j=2 时，我们需要将第 i 片叶子变成红色，而第 i-1 片叶子即可以处于 j=2 的状态，也可以处于 j=1 的状态（注意这里不能处于 j=0 的状态，因为每一种状态包含的叶子数量必须至少为 1），我们选择其中的较小值，因此有状态转移方程：
    f[i][2]=min{f[i−1][1],f[i−1][2]}+isYellow(i)
    最终的答案即为 f[n−1][2]，其中 nn 是字符串leaves 的长度，也就是树叶的总数。*/
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        // 3个状态：黄色前的红色；黄色；黄色后的红色
        // int[][] dp = new int[n][3];
        // dp[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        // dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        int redBefore = leaves.charAt(0) == 'y' ? 1 : 0;
        int yellow = Integer.MAX_VALUE;
        int redAfter = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            // dp[i][0] = dp[i - 1][0] + isYellow;
            // dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isRed;
            // if(i >= 2){
            //     dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
            // }
            int redBeforeTemp = redBefore + isYellow;
            int yellowTemp = Math.min(redBefore, yellow) + isRed;
            int redAfterTemp;
            if(i >= 2){
                redAfterTemp = Math.min(yellow, redAfter) + isYellow;
            }else{
                redAfterTemp = redAfter;
            }
            redBefore = redBeforeTemp;
            yellow = yellowTemp;
            redAfter = redAfterTemp;
        }
        return redAfter;
    }

    /**
     * 面试题 08.01. 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * 输入：n = 3     输出：4       说明: 有四种走法
     *  输入：n = 5    输出：13
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if(n == 1){
            return dp[0];
        }
        dp[1] = 2;
        if(n == 2){
            return dp[1];
        }
        dp[2] = 4;
        if(n == 3){
            return dp[2];
        }
        for(int i = 3; i < n; i++){
            dp[i] = (int)(((long)dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000007);
        }
        return dp[n - 1];
    }

    /**
     * 279. 完全平方数
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 输入: n = 12   输出: 3   解释: 12 = 4 + 4 + 4.
     * 输入: n = 13   输出: 2   解释: 13 = 4 + 9.
     * @param n
     * @return
     */
  /*  首先初始化长度为 n+1 的数组 dp，每个位置都为 0
    如果 n 为 0，则结果为 0
    对数组进行遍历，下标为 i，每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4，最坏结果为 4=1+1+1+1 即为 4 个数字
    动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i 表示当前数字，j*j 表示平方数
    时间复杂度：O(n*sqrt(n))，sqrt 为平方根*/
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = i;// 最坏情况:1+1+1
            for(int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 746. 使用最小花费爬楼梯
     * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     * 输入: cost = [10, 15, 20]      输出: 15      解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
     * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]      输出: 6       解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
     * 1.cost 的长度将会在 [2, 1000]。2.每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];// 一步
        dp[1] = cost[1];//两步
        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 542. 01 矩阵
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。两个相邻元素间的距离为 1 。
     * 输入：[[0,0,0],[0,1,0],[1,1,1]]      输出：[[0,0,0],[0,1,0],[1,2,1]]
     * 1.给定矩阵的元素个数不超过 10000。2.给定矩阵中至少有一个元素是 0。3.矩阵中的元素只在四个方向上相邻: 上、下、左、右。
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], 10001);
        }
        //填充所有的0元素
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }
            }
        }
        // 从左上角遍历整个矩阵
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i > 0){
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                }
                if(j > 0){
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                }
            }
        }
        // 从右下角遍历整个矩阵
        for(int i = row - 1; i >= 0; i--){
            for(int j = col - 1; j >= 0; j--){
                if(i < row - 1){
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);
                }
                if(j < col - 1){
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j + 1]);
                }
            }
        }
        return dp;
    }

    /**
     * 845. 数组中的最长山脉
     * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： B.length >= 3
     * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]（注意：B 可以是 A 的任意子数组，包括整个数组 A。）
     * 给出一个整数数组 A，返回最长 “山脉” 的长度。如果不含有 “山脉” 则返回 0。
     * 输入：[2,1,4,7,3,2,5]       输出：5        解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
     * 输入：[2,2,2]               输出：0        解释：不含 “山脉”。
     * 1.0 <= A.length <= 10000         2.0 <= A[i] <= 10000
     * @param A
     * @return
     */
    public static int longestMountain(int[] A) {
        int n = A.length;
        int[] left = new int[n];// 左边递增的个数
        int[] right = new int[n];// 右边递减的个数
        for(int i = 1; i < n - 1; i++){
            if(A[i] > A[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = n - 2; i > 0; i--){
            if(A[i] > A[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            if(left[i] > 0 && right[i] > 0){
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    /**
     * 718. 最长重复子数组
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * 输入： A: [1,2,3,2,1]    B: [3,2,1,4,7]     输出：3    解释：长度最长的公共子数组是 [3, 2, 1] 。
     * 1.1 <= len(A), len(B) <= 1000        2.0 <= A[i], B[i] < 100
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
//        dp[i][j] 代表 i、j重复数组的长度； 转移方程  dp[i][j] = dp[i + 1][j + 1] + 1
        int ans = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for(int i = A.length - 1; i >= 0; i--){
            int temp = 0;
            for(int j = B.length - 1; j >= 0; j--){
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1: 0;
                temp = Math.max(temp, dp[i][j]);
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }


    /**
     * 238. 除自身以外数组的乘积
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * 输入: [1,2,3,4]        输出: [24,12,8,6]
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * 进阶：你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] ans = new int[n];
        left[0] = 1;
        for(int i = 1; i < n; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        int rightAns = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] = left[i] * rightAns;
            rightAns *= nums[i];
        }
        return ans;
    }

    /**
     * 面试题 17.16. 按摩师
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     * 输入： [1,2,3,1]    输出： 4       解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     * 输入： [2,7,9,3,1]  输出： 12      解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     * 输入： [2,1,4,5,3,1,1,3]      输出： 12    解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        if(nums.length == 1){
            return ans[0];
        }
        ans[1] = nums[1];
        if(nums.length == 2){
            return Math.max(ans[0], ans[1]);
        }
        ans[2] = nums[0] + nums[2];
        if(nums.length == 2){
            return Math.max(ans[1], ans[2]);
        }
        for(int i = 3; i < nums.length; i++){
            ans[i] = Math.max(ans[i - 3], ans[i - 2]) + nums[i];
        }
        return Math.max(ans[nums.length - 2], ans[nums.length - 1]);
    }

    public static void main(String[] args){
      /*  int[][] costs = new int[3][3];
        costs[0][0] = 17;
        costs[0][1] = 2;
        costs[0][2] = 17;

        costs[1][0] = 16;
        costs[1][1] = 16;
        costs[1][2] = 5;

        costs[2][0] = 14;
        costs[2][1] = 3;
        costs[2][2] = 19;
        System.out.println(minCost(costs));*/
       /* List<Integer> param1 = new ArrayList(){{add(2);}};
        List<Integer> param2 = new ArrayList(){{add(3);add(4);}};
        List<Integer> param3 = new ArrayList(){{add(6);add(5);add(7);}};
        List<Integer> param4 = new ArrayList(){{add(4);add(1);add(8);add(3);}};
        List<List<Integer>> params = new ArrayList(){{add(param1);add(param2);add(param3);add(param4);}};
        System.out.println(minimumTotal(params));*/
//        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
       /* System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));*/
//        System.out.println(productExceptSelf(new int[]{1,2,3,4}));
        System.out.println(massage(new int[]{2,7,9,3,1}));

        for(int i = 0; i < 5; i++){
            if(i == 3){
                return;
            }
            System.out.println(i);
        }
        System.out.println(11111);
    }
}
