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



    public static void main(String[] args){
        //"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
        System.out.println(validPalindrome("lcuppucul") );

    }
}
