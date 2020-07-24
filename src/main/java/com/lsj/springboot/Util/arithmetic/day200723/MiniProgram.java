package com.lsj.springboot.Util.arithmetic.day200723;

import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目3：无重复字符的最长子串
 * abcabcbb 最长字串abc; bbbbb 最长字串b; pwwkew 最长字串wke
 * 滑动窗口
 *
 * 题目5：最长回文字串
 * 滑动窗口暴力破解、动态规划
 */
public class MiniProgram {

    public static void main(String[] args){
       /* System.out.println(longest("abcabcbb"));
        System.out.println(longest("bbbbb"));
        System.out.println(longest("pwwkew"));*/

        System.out.println(longestPalindromeStr("babad"));
        System.out.println(longestPalindromeStr("abbd"));
    }

    /**
     * 题目3：无重复字符的最长子串
     * @param str
     * @return
     */
    public static int longest(String str){

        Set<Character> set = new HashSet<>();
        int length = str.length();
        int start = 0;
        int end = 0;
        int max = 0;

        for(int i = 0; i < length; i++){
            // 删掉前一个元素
            start = i;
            if(start != 0){
                set.remove(str.charAt(start - 1));
            }
            // 后面的指针指向的元素在集合中不存在加入到集合中
            while(end < length && !set.contains(str.charAt(end))){
                set.add(str.charAt(end));
                end ++;
            }
            // 获取最大值
            max = Math.max(max, end - start);
        }

        return max;
    }


    /**
     * 题目5：最长回文子串
     * 输入 babad 输出 bab或者aba
     * 输入 abbd 输出 bb
     * @param str
     * @return
     */
    public static String longestPalindromeStr(String str){

        String palindromeStr = "";
        int len = str.length();
        for(int i = 0; i < len; i++){
            int start = 0;
            int end = len - i;
            while(end <= str.length()) {
                String subStr = str.substring(start, end);
                String reverseStr = new StringBuilder(subStr).reverse().toString();
                if (subStr.equals(reverseStr)) {
                    palindromeStr = subStr;
                    break;
                }
                start++;
                end++;
            }
            if(!StringUtils.isEmpty(palindromeStr)){
                break;
            }
        }

        return palindromeStr;
    }

}
