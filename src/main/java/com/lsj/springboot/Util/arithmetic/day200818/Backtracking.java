package com.lsj.springboot.Util.arithmetic.day200818;

import java.util.ArrayList;
import java.util.Arrays;
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
     *  回溯算法
     *  []
     *  [1][1,2][1,2,3]
     *     [1,3]
     * [2][2,3]
     * [3]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
       /* // 迭代
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
        return ans;*/
        // 回溯算法
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, ans, nums, new ArrayList<>());
        return ans;
    }

    public static void subsets(int k, List<List<Integer>> ans, int[] nums, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        // 第一层4种选择；第二层3种选择；第三层2种选择；第四层1种选择
        for(int j = k; j < nums.length; j++){
            temp.add(nums[j]);// 本层做出选择
            subsets(j + 1, ans, nums, temp);// 进入下一层做出选择
            temp.remove(temp.size() - 1);//本层做出调整
        }
    }

    /**
     * 90. 子集 II
     * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。
     * 输入: [1,2,2]  输出: [[2], [1],[1,2,2],[2,2], [1,2],[]]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);// 排序
        subsets2(0, ans, nums, new ArrayList<>());
        return ans;
    }

    public void subsets2(int k, List<List<Integer>> ans, int[] nums, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        // 第一层4种选择；第二层3种选择；第三层2种选择；第四层1种选择
        for(int j = k; j < nums.length; j++){
            if(j > k && nums[j] == nums[j - 1]){// 与上一个值相等，不作为本层的选择
                continue;
            }
            temp.add(nums[j]);// 本层做出选择
            subsets2(j + 1, ans, nums, temp);// 进入下一层做出选择
            temp.remove(temp.size() - 1);//本层做出调整
        }
    }

    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }



}
