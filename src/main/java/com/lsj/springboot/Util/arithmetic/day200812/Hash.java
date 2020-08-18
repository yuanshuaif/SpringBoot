package com.lsj.springboot.Util.arithmetic.day200812;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10326 on 2020/8/17.
 *
 * 题目350：两个数组的交集 II
 * hash表
 *
 * 题目532:数组中的K-diff数对
 * hash表
 *
 * 题目242:有效的字母异位词
 *
 * 题目136:只出现一次的数字
 * hash表  位运算-异或
 */
public class Hash {

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]  输出：[2,2]
     * 时间复杂度：O(m+n)         空间复杂度：O(\min(m,n))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // hash表的方式
        if(nums1.length > nums2.length){
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for(Integer integer : nums1){
            Integer count = hash.getOrDefault(integer, 0) + 1;
            hash.put(integer, count);
        }
        int[] ans = new int[nums1.length];
        int k = 0;
        for(int i = 0; i < nums2.length; i++){
            Integer count = hash.getOrDefault(nums2[i], 0);
            if(count > 0){
                ans[k++] = nums2[i];
                count--;
                hash.put(nums2[i], count);
            }
        }
        return Arrays.copyOf(ans, k);
    }

    /**
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j),
     * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     * 输入: [3, 1, 4, 1, 5], k = 2   输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。尽管数组中有两个1，但我们只应返回不同的数对的数量
     * 输入:[1, 2, 3, 4, 5], k = 1    输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 输入: [1, 3, 1, 5, 4], k = 0   输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer, Integer> map =  new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(k == 0 && value > 1){
                ans++;
            }else if(k > 0 && map.containsKey(key - k)){
                ans ++;
            }
        }
        return ans;
    }

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 输入: s = "anagram", t = "nagaram" 输出: true
     * 输入: s = "rat", t = "car" 输出: false
     * 你可以假设字符串只包含小写字母。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //hash表
        if(s.length() != t.length()){
            return false;
        }
        int[] ans = new int[26];
        for(int i = 0; i < s.length(); i++){
            ans[s.charAt(i) - 'a']++;
            ans[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < ans.length; i++){
            if(ans[i] != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : nums){
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        int target = 0;
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() == 1){
//                target = entry.getKey();
//            }
//        }
//        return target;

        // 位运算~异或
        //1.a^0=a;
        //2.a^a=0;
        //3.满足交换律 a^b^a = a^a^b = 0^b = b;
        int target = 0;
        for(int num :nums){
            target ^= num;
        }
        return target;

    }

}
