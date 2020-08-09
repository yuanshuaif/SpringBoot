package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.Arrays;

/**
 *  动态规划
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
}


