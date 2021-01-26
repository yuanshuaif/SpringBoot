package com.lsj.springboot.arithmetic.greedy;

import java.util.Arrays;

/**
 * Created by 10326 on 2020/8/30.
 * 贪心算法
 *
 * 1.贪心：每一步的最优解一定包含上一步的最优解，上一步之前的最优解则不作保留；
 *   动态规划：全局最优解中一定包含某个局部最优解，但不一定包含前一个局部最优解，因此需要记录之前的所有的局部最优解
 * 2.贪心：如果把所有的子问题看成一棵树的话，贪心从根出发，每次向下遍历最优子树即可（通常这个“最优”都是基于当前情况下显而易见的“最优”）；这样的话，就不需要知道一个节点的所有子树情况，于是构不成一棵完整的树；
 *   动态规划：动态规划则自底向上，从叶子向根，构造子问题的解，对每一个子树的根，求出下面每一个叶子的值，最后得到一棵完整的树，并且最终选择其中的最优值作为自身的值，得到答案
 * 3.根据以上两条可以知道，贪心不能保证求得的最后解是最佳的，一般复杂度低；而动态规划本质是穷举法，可以保证结果是最佳的，复杂度高。
 *
 * 题目860:柠檬水找零
 *
 * 题目605:种花问题
 *
 * 题目455:分发饼干
 *
 * 题目122:买卖股票的最佳时机 II
 * 峰谷法
 *
 * 题目1046:最后一块石头的重量
 *
 * 题目1518:换酒问题
 *
 * 题目1221:分割平衡字符串
 */
public class GreedyAlgorithm {

    /**
     * 860. 柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * 输入：[5,5,5,10,20] 输出：true
     * 解释：前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。由于所有客户都得到了正确的找零，所以我们输出 true。
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five >= 1){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else if(bill == 20){
                if(ten >= 1 && five >= 1){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 605. 种花问题
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     *  输入: flowerbed = [1,0,0,0,1], n = 1 输出: True;                输入: flowerbed = [1,0,0,0,1], n = 2 输出: False
     *  注意:1.数组内已种好的花不会违反种植规则。2.输入的数组长度范围为 [1, 20000]。3. n 是非负整数，且不会超过输入数组的大小。
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null){
            return false;
        }
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            //贪心算法
            // 当前节点如果是头结点：当前节点是0，下一个节点是0，可种植数+1，当前节点由0变1；
            // 当前节点如果是尾结点：当前节点是0，前一个节点是0，可种植数+1，当前节点由0变1；
            // 中间节点：当前节点是0，前一个节点是0，后一个节点是0，可种植数+1，当前节点由0变1；
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1  || flowerbed[i + 1] == 0)){
                count ++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }

    /**
     * 455. 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
     * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * 你可以假设胃口值为正。一个小朋友最多只能拥有一块饼干。
     * 输入: [1,2,3], [1,1]    输出: 1
     * 解释:你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。所以你应该输出1。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cur = 0;
        int ans = 0;
        for(int i = 0; i < g.length; i++){
            while(cur < s.length){
                if(g[i] <= s[cur++]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 输入: [7,1,5,3,6,4]    输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 输入: [7,6,4,3,1]      输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 峰谷法
        int valley = prices[0];//山谷
        int peek = prices[0];//山峰
        int ans = 0;
        int i = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i + 1] ){
                i++;
            }
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1] ){
                i++;
            }
            peek = prices[i];
            ans += peek - valley;
        }
        return ans;
       /* int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= prices[i - 1]){
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;*/
    }

    /**
     * 1046. 最后一块石头的重量
     * 有一堆石头，每块石头的重量都是正整数。
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * 如果 x == y，那么两块石头都会被完全粉碎；如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * 输入：[2,7,4,1,8,1]         输出：1
     * 解释：先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
     *      接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return 0;
        }else if(stones.length == 1){
            return stones[0];
        }
        Arrays.sort(stones);
        while(stones[stones.length - 2] != 0){// 倒数第二个不为0继续计算
            stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones[stones.length - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

    /**
     * 1518. 换酒问题
     * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
     * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。       请你计算 最多 能喝到多少瓶酒。
     * 输入：numBottles = 9, numExchange = 3           输出：13
     * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。   所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
     * 输入：numBottles = 15, numExchange = 4          输出：19
     * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。   所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
     * 输入：numBottles = 5, numExchange = 5           输出：6
     * 输入：numBottles = 2, numExchange = 3           输出：2
     * @param numBottles
     * @param numExchange
     * @return
     */
    private int ans;
    public int numWaterBottles(int numBottles, int numExchange) {
        ans = numBottles;
        numEmptyBottles(numBottles, numExchange);
        return ans;
    }

    public void numEmptyBottles(int numEmptyBottles, int numExchange) {
        int numBottles = numEmptyBottles / numExchange;
        if(numBottles == 0){
            return ;
        }
        ans += numBottles;
        numEmptyBottles = numBottles + numEmptyBottles % numExchange;
        numEmptyBottles(numEmptyBottles, numExchange);
    }

    /**
     * 1221. 分割平衡字符串
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * 返回可以通过分割得到的平衡字符串的最大数量。
     * 输入：s = "RLRRLLRLRL"      输出：4    解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     * 输入：s = "RLLLLRRRLR"      输出：3    解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int ans = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R'){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                ans++;
            }
        }
        return ans;
    }
}
