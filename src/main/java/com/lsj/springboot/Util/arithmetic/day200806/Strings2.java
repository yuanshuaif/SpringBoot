package com.lsj.springboot.Util.arithmetic.day200806;

/**
 * 680. 验证回文字符串 Ⅱ
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



    public static void main(String[] args){
        //"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
        System.out.println(validPalindrome("lcuppucul") );

    }
}
