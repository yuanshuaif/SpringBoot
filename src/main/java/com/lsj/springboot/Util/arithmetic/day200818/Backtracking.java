package com.lsj.springboot.Util.arithmetic.day200818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法
 * 78. 子集
 *
 * 39. 组合总和
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

    /**
     * 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。
     * 输入：candidates = [2,3,6,7], target = 7,所求解集为：[[7],[2,2,3]]
     * 输入：candidates = [2,3,5], target = 8,所求解集为：[[2,2,2,2],[2,3,3],[3,5]]
     * 1 <= candidates.length <= 30         1 <= candidates[i] <= 200       candidate 中的每个元素都是独一无二的。        1 <= target <= 500
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    public void combinationSum(int[] candidates, int target, int start,
                               List<List<Integer>> res, List<Integer> temp) {
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                return;
            }
            temp.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }



}
