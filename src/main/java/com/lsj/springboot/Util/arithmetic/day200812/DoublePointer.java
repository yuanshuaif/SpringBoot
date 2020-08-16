package com.lsj.springboot.Util.arithmetic.day200812;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目26:删除排序数组中的重复项
 * 双指针
 *
 * 题目88(10.01):合并排序的数组
 * 利用归并排序进行merge
 *
 * 题目167：两数之和 II - 输入有序数组
 *
 * 题目344：反转字符串
 * 双指针
 *
 * 题目283:移动零
 * 双指针
 *
 * 题目27:移除元素（同26）
 * 双指针
 *
 * 题目125:验证回文串
 * 双指针
 *
 * 题目345：反转字符串中的元音字母
 *
 * 题目977：有序数组的平方
 * 双指针
 *
 * 题目11:盛最多水的容器
 * 双指针
 *
 * 题目532:数组中的K-diff数对
 * hash表
 *
 * 题目844：比较含退格的字符串
 *
 */
public class DoublePointer {

    public static void main(String[] args){
//        int[] A = new int[]{-4,-1,0,3,10};
//        System.out.println(sortedSquares(A));
        System.out.println(backspaceCompare("ad#c", "ab#c"));

    }

    /**
     * 26.删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复的数组，使得每一个元素只出现一次，返回新数组的长度
     * 不要使用额外的数组空间，并在原地修改输入数组  元素的顺序可以改变        nums{0,0,1,1,1,2,2,3,3,4}
     * @param original
     * @return
     */
    private static int deleteCommonItem(Integer[] original){
        if(original == null){
            return 0;
        }else if(original.length < 2){
            return original.length;
        }
        int cur = 0;
        for(int i = 1; i < original.length; i++){
            if(original[cur] != original[i]){
                original[++cur] = original[i];
            }
        }
        return (cur + 1);
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 输入: nums1 = [1,2,3,0,0,0], m = 3   nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge88(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m); // [0,0,0,1,2,3]
        int index1 = n, index2 = 0;
        int index = 0;
        while (index1 < n + m && index2 < n){
            if(nums1[index1] > nums2[index2]){
                nums1[index++] = nums2[index2++];
            }else if(nums1[index1] < nums2[index2]){
                nums1[index++] = nums1[index1++];
            }else{
                nums1[index++] = nums1[index1++];
                nums1[index++] = nums2[index2++];
            }
        }
        while (index2 < n){
            nums1[index++] = nums2[index2++];
        }
        while (index1 < n + m){
            nums1[index++] = nums1[index1++];
        }
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int start = 0;
        int end = nums.length - 1;
        int[] ints = new int[2];
        while (start < end){
            if(nums[start] + nums[end] == target){
                ints[0] = start + 1;
                ints[1] = end + 1;
                start++;
            }else if(nums[start] + nums[end] < target){
                start++;
            }else {
                end--;
            }
        }
        return ints;
    }

    /**
     * 344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。  你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     * 输入：["h","e","l","l","o"]  输出：["o","l","l","e","h"]
     * 输入：["H","a","n","n","a","h"]  输出：["h","a","n","n","a","H"]
     *
     * @param s
     */
    public char[] reverseString(char[] s) {
        char temp;
        for(int i = 0; i < s.length / 2; i++){
            temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return s;
    }

    /**
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 输入: [0,1,0,3,12]     输出: [1,3,12,0,0]
     * 1.必须在原数组上操作，不能拷贝额外的数组。2.尽量减少操作次数。
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int cur = 0;
        int len = 0;
        for(; len < nums.length; len++){
            if(nums[len] != 0){
                nums[cur++] = nums[len];
            }
        }
        for(int j = cur; j < len; j++){
            nums[j] = 0;
        }
        System.out.println(nums);
    }

    /**
     * 27.移除元素(思路同删除重复项)
     * 给定一个排序数组nums和一个值val，你需要在原地删除值等于val的元素，返回新数组的长度
     * 不要使用额外的数组空间，并在原地修改输入数组 元素的顺序可以改变         nums{3,2,3,1,4,5,3,2,1}
     * @param original
     * @return
     */
    private static int deleteAssignItem(Integer[] original, int target){
        if(original == null){
            return 0;
        }
        int cur = 0;
        for(int i = 0; i < original.length; i++){
            if(original[i] != target){
                original[cur++] = original[i];
            }
        }
        return cur;
    }

    /**
     * 125. 验证回文串
     *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 输入: "A man, a plan, a canal: Panama" 输出: true
     * 输入: "race a car" 输出: false
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }


    /**
     * 345. 反转字符串中的元音字母
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * 输入: "leetcode"    输出: "leotcede"
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";// 元音字符
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while(start < end){
            while(start < end && !vowels.contains(chars[start] + "")){
                start++;
            }
            while(start < end && !vowels.contains(chars[end] + "")){
                end--;
            }
            // 找到一对、交换
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }


    /**
     * 977. 有序数组的平方
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * [-4,-1,0,3,10] [-7,-3,2,3,11] [-7,-3,2,8,11]
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int[] result = new int[A.length];
        int cur = A.length - 1;
        while(start < end){
            if(A[start] * A[start] < A[end] * A[end]){
                result[cur--] = A[end] * A[end];
                end--;
            }else if(A[start] * A[start] > A[end] * A[end]){
                result[cur--] = A[start] * A[start];
                start++;
            }else{
                result[cur--] = A[end] * A[end];
                result[cur--] = A[start] * A[start];
                start++;
                end--;
            }
        }
        if(start == end){
            result[0] = A[start] * A[start];
        }
        return result;
    }

    /**
     * 题目11:盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     说明：你不能倾斜容器，且 n 的值至少为 2。
     输入：[1,8,6,2,5,4,8,3,7] 输出：49
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 双指针
        int start = 0;
        int end = height.length - 1;
        int maxCatacity = 0;
        while(start < end){
            int wide = end - start;// 桶的宽
            int minHeight = Math.min(height[start], height[end]);// 桶单的最小高
            maxCatacity = Math.max(maxCatacity, wide * minHeight);
            // 移动小的边
            if(minHeight == height[start]){
                start++;
            }else{
                end--;
            }
        }
        return maxCatacity;
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
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * 输入：S = "ab#c", T = "ad#c"     输出：true    解释：S 和 T 都会变成 “ac”。
     * 输入：S = "ab##", T = "c#d#"     输出：true    解释：S 和 T 都会变成 “”。
     * 输入：S = "a##c", T = "#a#c"     输出：true    解释：S 和 T 都会变成 “c”。
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {
        int curS = 0;
        int indexS = 0;
        char[] charS = S.toCharArray();
        int curT = 0;
        int indexT = 0;
        char[] charT = T.toCharArray();
        for(; indexS < charS.length; indexS++){
            if(charS[indexS] == '#' && curS == 0){
            }else if(charS[indexS] == '#'){
                curS--;
            }else{
                charS[curS++] = charS[indexS];
            }
        }
        char[] charSR = Arrays.copyOf(charS, curS);
        for(; indexT < charT.length; indexT++){
            if(charT[indexT] == '#' && curT == 0){
            }else if(charT[indexT] == '#'){
                curT--;
            }else{
                charT[curT++] = charT[indexT];
            }
        }
        char[] charTR = Arrays.copyOf(charT, curT);
        if(charSR.length != charTR.length){
            return false;
        }
        for(int j = 0; j < charTR.length; j++){
            if(charSR[j] != charTR[j]){
                return false;
            }
        }
        return true;
    }
}
