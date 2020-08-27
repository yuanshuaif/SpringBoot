package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.HashMap;
import java.util.Map;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * 1446. 连续字符
 *
 * 面试题 01.02. 判定是否互为字符重排
 *
 * Created by 10326 on 2020/8/26.
 */
public class Strings2 {

    /**
     * 680. 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 输入: "aba"    输出: True
     * 输入: "abca"   输出: True    解释: 你可以删除c字符。
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while(start < end){
            if(chars[start] == chars[end]){
                start++;
                end--;
            }else{
                return isPalindrome(chars, start + 1, end) || isPalindrome(chars, start, end - 1);
            }
        }
        return true;
    }

    public static boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 551. 学生出勤记录 I
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     * 'A' : Absent，缺勤      'L' : Late，迟到       'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * 输入: "PPALLP"     输出: True
     * 输入: "PPALLL"     输出: False
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        return false;
    }

    /**
     * 1446. 连续字符
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     * 请你返回字符串的能量。
     * 输入：s = "leetcode"    输出：2    解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
     * 输入：s = "abbcccddddeeeeedcba" 输出：5    解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
     * 输入：s = "triplepillooooow"    输出：5
     * @param s
     * @return
     */
    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        int ans = 1;
        int temp = 1;
        int start = 0;
        int end = 1;
        while(end < chars.length){
            if(chars[start] == chars[end]){
                start++;
                end++;
                temp++;
                ans = Math.max(temp, ans);
            }else{
                start++;
                end++;
                temp = 1;
            }
        }
        return ans;
    }

    /**
     * 面试题 01.02. 判定是否互为字符重排
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * 输入: s1 = "abc", s2 = "bca"   输出: true
     * 输入: s1 = "abc", s2 = "bad"   输出: false
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            hash.put(s1.charAt(i), hash.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for(int i = 0; i < s2.length(); i++){
            if(hash.containsKey(s2.charAt(i))){
                hash.put(s2.charAt(i), hash.get(s2.charAt(i)) - 1);
                if(hash.get(s2.charAt(i)) == 0){
                    hash.remove(s2.charAt(i));
                }
            }else{
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args){
//        System.out.println(validPalindrome("lcuppucul") );
//        System.out.println(maxPower("t") );
        System.out.println(CheckPermutation("abc", "bca") );

    }
}
