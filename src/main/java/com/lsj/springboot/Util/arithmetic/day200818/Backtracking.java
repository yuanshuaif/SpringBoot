package com.lsj.springboot.Util.arithmetic.day200818;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 * 78. 子集
 */
public class Backtracking {

    /**
     * 78. 子集
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 输入: nums = [1,2,3]
     * 输出:[[3],[1], [2],[1,2,3],[1,3],[2,3],[1,2],[]]
     * [[],
     *  [1] + []
     *  [1,2],[2] + [1],[]
     *  [1,2,3],[2,3],[1,3],[3] + [1,2],[2],[1],[]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        // 迭代
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : nums){
            List<List<Integer>> cur = new ArrayList<>();
            for(List<Integer> an : ans){
                cur.add(new ArrayList(an){{add(num);}});
            }
            for(List<Integer> cu : cur){
                ans.add(cu);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }



}
