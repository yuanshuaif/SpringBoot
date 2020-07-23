package com.lsj.springboot.Util.arithmetic.day200723;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目三：无重复字符的最长子串
 * abcabcbb 最长字串abc; bbbbb 最长字串b; pwwkew 最长字串wke
 * 滑动窗口
 */
public class MiniProgram {

    public static void main(String[] args){
        System.out.println(longest("abcabcbb"));
        System.out.println(longest("bbbbb"));
        System.out.println(longest("pwwkew"));
    }

    public static int longest(String str){

        Set<Character> set = new HashSet<>();
        int length = str.length();
        int start = 0;
        int end = 0;
        int max = 0;

        for(int i = 0; i < length; i++){
            start = i;
            if(start != 0){
                set.remove(str.charAt(start - 1));
            }
            while(end < length && !set.contains(str.charAt(end))){
                set.add(str.charAt(end));
                end ++;
            }
            max = Math.max(max, end - start);
        }

        return max;
    }

}
