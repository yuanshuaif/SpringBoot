package com.lsj.springboot.Util.arithmetic.day200818;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法
 * 78. 子集
 *
 * 90. 子集 II
 *
 * 39. 组合总和
 *
 * 46. 全排列
 *
 * 47. 全排列 II
 *
 * 77. 组合
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

    /**
     * 46. 全排列
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * 输入: [1,2,3]
     * 输出:[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, res, new ArrayList<>());
        return res;
    }

    public static void permute(int[] nums, List<List<Integer>> res, List<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            permute(nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * 输入: [1,1,2]          输出:[[1,1,2],[1,2,1],[2,1,1]]
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, res, new ArrayList<>(), new ArrayList<>());
        return res;
    }

    public static void permuteUnique(int[] nums, List<List<Integer>> res, List<Integer> temp, List<Integer> index){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(index.contains(i)){
                continue;
            }
            // 剪枝的核心算法：1）值与前一个值相等；2）前面一个没用到剪掉（说明前一个在前面的分支里已经用过了）
            if(i > 0 && nums[i] == nums[i - 1] && !index.contains(i - 1)){
                continue;
            }
            temp.add(nums[i]);
            index.add(i);
            permuteUnique(nums, res, temp, index);
            temp.remove(temp.size() - 1);
            index.remove(index.size() - 1);
        }
    }

    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 输入: n = 4, k = 2     输出: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if(k > n){
            return new ArrayList<>();
        }
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++){
            nums[i - 1] = i;
        }
        List<List<Integer>> res = new ArrayList<>();
        combine(nums, res, new ArrayList<>(), 0, k);
        return res;
    }

    public void combine(int[] nums, List<List<Integer>> res, List<Integer> temp, int start, int k) {
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            combine(nums, res, temp, i + 1, k);
            temp.remove(temp.size() - 1);
        }
        return;
    }

    /**
     * 面试题 08.07. 无重复字符串的排列组合
     * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
     * 输入：S = "qwe"     输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
     * 输入：S = "ab"      输出：["ab", "ba"]
     * 1.字符都是英文字母。2.字符串长度在[1, 9]之间。
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        return null;
    }

    public static void main(String[] args){
//        System.out.println(subsets(new int[]{1,2,3}));
//        System.out.println(permute(new int[]{1,2,3}));
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }



}
