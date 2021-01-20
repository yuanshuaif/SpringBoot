package com.lsj.springboot.Util.arithmetic.toDo.other;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by 10326 on 2020/8/9.
 *
 * 面试题 01.01. 判定字符是否唯一
 *
 * 题目13:罗马数字转整数
 *
 * 题目14:最长公共前缀
 *
 * 题目20:查找正确的括号
 *
 * 题目3:无重复字符的最长子串
 * 滑动窗口
 *
 * 题目28:实现indexOf()
 * 滑动窗口
 *
 * 1071.字符串的最大公因子
 * 辗转相除法
 *
 * 409. 最长回文串
 *
 * 680. 验证回文字符串 Ⅱ
 *
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 415. 字符串相加
 *
 * 67. 二进制求和（思想同上）
 *
 * 58. 最后一个单词的长度
 *
 * 557. 反转字符串中的单词 III
 *
 * 459. 重复的子字符串
 *
 * 面试题 01.09. 字符串轮转
 *
 * 1119. 删去字符串中的元音
 *
 * 657. 机器人能否返回原点
 *
 * 771. 宝石与石头
 *
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * 151. 翻转字符串里的单词
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * 434. 字符串中的单词数
 *
 * 面试题 01.02. 判定是否互为字符重排
 *
 * 1446. 连续字符
 *
 * 541. 反转字符串 II
 *
 * 面试题 01.06. 字符串压缩
 *
 * 917. 仅仅反转字母
 *
 * Linux语法简化规则(字节 13题的变种)
 */
public class Strings {

    public static void main(String[] args){
     /*   System.out.println(integerInversion(-123));
        System.out.println(integerInversion(1534236469));*/
//        System.out.println(isPalindrome(-232));
//        System.out.println(roman2Int("MCMXCIV"));
//        System.out.println(linuxRules("/c/d/////././../e/."));
        System.out.println(linuxRules("/c/d/////././../e/"));
//        System.out.println(linuxRules("/c/d/////././../e/.."));
//        System.out.println(linuxRules("/c/d/////././../ed/.."));
//        System.out.println(linuxRules("/c/d/////././../ed/."));
       /* String[] strs = new String[]{"flower","ooow","flight","flosh"};
        System.out.println(longestCommonPrefix(strs));*/
       /* System.out.println( findRealParentheses("()[]{}"));
        System.out.println( findRealParentheses("))[]{}"));
        System.out.println( findRealParentheses("()[]{(}"));
        System.out.println( findRealParentheses("[()[]]{}"));*/
        /*Integer[] firstList = new Integer[]{1, 5, 6};
        Integer[] secondList = new Integer[]{1, 3, 4, 6};
        int i = 0;
        Integer[] combileList = combine(firstList, secondList);
        while (i < combileList.length) {
            System.out.println(combileList[i]);
            i++;
        }*/
       /* Integer[] original = new Integer[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(deleteCommonItem(original));*/
       /* Integer[] original = new Integer[]{3,2,3,1,4,5,3,2,1};
        System.out.println(deleteAssignItem(original, 3));*/
//        System.out.println(indexOf("hello", "ll"));
//        System.out.println(indexOf("aaaaa", "aab"));

      /*  System.out.println(longest("abcabcbb"));
        System.out.println(longest("bbbbb"));
        System.out.println(longest("pwwkew"));*/

        /*System.out.println(longestPalindromeStr("babad"));
        System.out.println(longestPalindromeStr("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));*/

        /*  int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        System.out.println(isRectangleOverlap(rec1, rec2));*/
       /* 输入: A = [1,2,3,0,0,0], m = 3;  B = [2,5,6],  n = 3
      输出: [1,2,2,3,5,6]*/

//       System.out.println(validPalindrome("lcuppucul") );
//        System.out.println(maxPower("t") );
//        System.out.println(CheckPermutation("abc", "bca") );
//        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!") );
//        System.out.println(countSegments(", , , ,        a, eaefa") );

//        System.out.println(reverseWords("the sky is blue") );
    }

    /**
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。不使用额外的数据结构
     * 输入: s = "leetcode" 输出: false ;   输入: s = "abc"  输出: true
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        boolean flag = true;
        for(int i = 0; i < astr.length(); i++){
            if(astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 13.罗马数字转整数
     * 罗马数字包含以下7种字符:I、V、X、L、C、D、M， 给定一个罗马数字转化成整数（1-3999）
     * 数字值I->1,V->5,X->10,L->50,C->100,D->500,M->1000
     * 例如：罗马数字2写作II,罗马数字27写作XXVII    LVIII->58   MCMXCIV->1994
     * 6个特殊情况： I放到 V和X的左边，表示4，9；    X放到 L和C的左边，表示40，90;     C放到 D和M的右边，表示400,900
     * @return
     */
    public static int roman2Int(String str){
        char[] chars = str.toCharArray();
        int target = 0;
        for(int i = 0; i < chars.length; i++){
            switch (chars[i]){
                case 'V':
                    target += 5;
                    break;
                case 'L':
                    target += 50;
                    break;
                case 'D':
                    target += 500;
                    break;
                case 'M':
                    target += 1000;
                    break;
                case 'I': {
                    if(i == chars.length - 1){
                        target += 1;
                        break;
                    }else {
                        switch (chars[i + 1]) {
                            case 'V':
                                i++;
                                target += 4;
                                break;
                            case 'X':
                                i++;
                                target += 9;
                                break;
                            default:
                                target += 1;
                                break;
                        }
                        break;
                    }

                }
                case 'X': {
                    if(i == chars.length - 1){
                        target += 10;
                        break;
                    }else {
                        switch (chars[i + 1]) {
                            case 'L':
                                i++;
                                target += 40;
                                break;
                            case 'C':
                                i++;
                                target += 90;
                                break;
                            default:
                                target += 10;
                                break;
                        }
                        break;
                    }

                }
                case 'C': {
                    if(i == chars.length - 1){
                        target += 100;
                        break;
                    }else {
                        switch (chars[i + 1]) {
                            case 'D':
                                i++;
                                target += 400;
                                break;
                            case 'M':
                                i++;
                                target += 900;
                                break;
                            default:
                                target += 100;
                                break;
                        }
                        break;
                    }

                }
                default:
                    break;
            }
        }
        return target;
    }

    /**
     * 14.查找字符串数组中的最长公共前缀
     * 如果不存在公共前缀，返回空字符串,所有输入只包含小写字母a-z  例如：输入{"flower","flow","flight","flosh"} 输出"fl"
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        String common = strs[0];
        for(int i = 1; i < strs.length; i++){
            String cur = strs[i];
            int minLength = Math.min(common.length(), cur.length());
            int commonIndex = 0;
            for(int j = 0; j < minLength; j++){
                if(common.charAt(j) != cur.charAt(j)){
                    break;
                }
                commonIndex++;
            }
            common = common.substring(0, commonIndex);
            if("".equals(common)){
                break;
            }
        }
        return common;
    }

    /**
     * 20.寻找正确的括号
     * 给定一个括号的字符串，必须以正确的顺序闭合,()[]{}  ([{}]) 分为并排、嵌套2种
     * @param parentheses
     * @return
     */
    public static boolean findRealParentheses(String parentheses){
     /*   // 暴力破解法
         执行用时：55 ms, 在所有 Java 提交中击败了5.33%的用户
         内存消耗：40.2 MB, 在所有 Java 提交中击败了5.48%的用户
        if("".equals(parentheses)){// 空串认为是有效字符串
            return true;
        }else if(parentheses.length() % 2 != 0){// 奇数直接返回
            return false;
        }
        while(parentheses.contains("()") || parentheses.contains("{}") || parentheses.contains("[]")){
            parentheses = parentheses.replace("()", "");
            parentheses = parentheses.replace("{}", "");
            parentheses = parentheses.replace("[]", "");
        }
        if("".equals(parentheses)){
            return true;
        }
        return false;*/
        // 入栈法
//        执行用时：2 ms, 在所有 Java 提交中击败了 80.05% 的用户
//        内存消耗：37.7 MB, 在所有 Java 提交中击败了 5.48% 的用户
        // 思路：初始化栈；一次处理一个括号；如果是开括号入栈；如果是必括号从栈中取出一个判断是否是对，
        //  如果是一对继续，不是终止，结束后判断栈中是否还有元素，有返回false
        Map<Character,Character> map = new HashMap(){{
            put('{','}'); put('[',']'); put('(',')');
        }};
        char[] chars = parentheses.toCharArray();
        if("".equals(parentheses)){// 空串认为是有效字符串
            return true;
        }else if(parentheses.length() % 2 != 0 || !map.containsKey(chars[0])){// 奇数或者以)]}开始直接返回
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                stack.push(chars[i]);
            }else{
                if(stack.isEmpty() || map.get(stack.pop()) != chars[i]){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 题目3：无重复字符的最长子串
     * abcabcbb 最长字串abc; bbbbb 最长字串b; pwwkew 最长字串wke
     * @param str
     * @return
     */
    public static int longest(String str){
        Set<Character> set = new HashSet<>();
        int length = str.length();
        int start = 0;
        int end = 0;
        int max = 0;
        for(;start < length; start++){
            if(start > 0){
                set.remove(str.charAt(start - 1));
            }
            while(end < length && !set.contains(str.charAt(end))){
                set.add(str.charAt(end++));
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    /**
     * 28.实现indexOf(),
     * haystack = "hello", needle = "ll" 返回2；
     * haystack = "aaaa", needle = "bba" 返回-1;
     * needle = ""，返回0
     * 时间复杂度((N-L)L)
     * @param orignal
     * @param findStr
     */
    private static int indexOf(String orignal, String findStr){
        if("".equals(findStr)){
            return 0;
        }else if(findStr.length() > orignal.length() || "".equals(orignal) || !orignal.contains(findStr)){
            return -1;
        }
        int index = -1;
        // 1.滑动窗口
        for(int i = 0; i <= orignal.length() - findStr.length(); i++){
            int num = 0;
            if(orignal.charAt(i) != findStr.charAt(0)){
                continue;
            }
            for(int j = 0; j < findStr.length(); j++){
                if(orignal.charAt(i + j) != findStr.charAt(j)){
                    break;
                }else{
                    num++;
                }
            }
            if(num == findStr.length()){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 1071.字符串的最大公因子
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        // 辗转相除法
        // int r = 0;
        // while(b != 0){
        //     r = a % b;
        //     a = b;
        //     b = r;
        // }
        // return a;
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 输入: "abccccdd" 输出: 7         解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        // A-Z 65-90; a-z 97-122
        // 记录各个字符出现的次数
        int[] ch = new int[58];
        for(char c : s.toCharArray()){
            ch[c - 'A'] += 1;
        }
        int ans = 0;
        for(int x : ch){
            // x & 1 偶数的0, 奇数需要减1
            ans += x - (x & 1);
        }
        return ans < s.length() ? (ans + 1) : ans;
    }

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
     * 剑指 Offer 03. 数组中重复的数字
     * 输入： [2, 3, 1, 0, 2, 5, 3]     输出：2 或 3   限制：2 <= n <= 100000
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int find = -1;
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){
                find = nums[i];
                break;
            }
        }
        return find;
    }

    /**
     * 415. 字符串相加
     *  给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *  num1 和num2 的长度都小于 5100; num1 和num2 都只包含数字 0-9;  num1 和num2 都不包含任何前导零
     *  你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {

        // 执行用时：5 ms, 在所有 Java 提交中击败了18.40%的用户
        // 内存消耗：39.8 MB, 在所有 Java 提交中击败了53.79%的用户
        // int maxLength = Math.max(num1.length(), num2.length());
        // Stack stack = new Stack();
        // int carry = 0;
        // for(int i = 1; i <= maxLength; i++){
        //     char char1 = num1.length() - i < 0 ? '0' : num1.charAt(num1.length() - i);
        //     char char2 = num2.length() - i < 0 ? '0' : num2.charAt(num2.length() - i);
        //     int sum = (char1 - '0') + (char2 - '0') + carry;
        //     stack.push(sum % 10);
        //     carry = sum / 10;
        // }
        // if(carry > 0){// 1 + 9
        //     stack.push(carry);
        // }

        // StringBuilder str = new StringBuilder();
        // while(!stack.isEmpty()){
        //     str.append(stack.pop());
        // }
        // return str.toString();

        // 执行用时：2 ms, 在所有 Java 提交中击败了99.78%的用户
        // 内存消耗：39.3 MB, 在所有 Java 提交中击败了99.92%的用户
        int maxLength = Math.max(num1.length(), num2.length());
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for(int i = 1; i <= maxLength; i++){
            char char1 = num1.length() - i < 0 ? '0' : num1.charAt(num1.length() - i);
            char char2 = num2.length() - i < 0 ? '0' : num2.charAt(num2.length() - i);
            int sum = (char1 - '0') + (char2 - '0') + carry;
            str.append(sum % 10);
            carry = sum / 10;
        }
        if(carry > 0){// 1 + 9
            str.append(carry);
        }
        return str.reverse().toString();
    }

    /**
     * 67. 二进制求和
     * 输入: a = "11", b = "1"    输出: "100" ;         输入: a = "1010", b = "1011"  输出: "10101"
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        // 与10进制的求和思想一致
        int maxLength = Math.max(a.length(), b.length());
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for(int i = 1; i <= maxLength; i++){
            char char1 = a.length() - i < 0 ? '0' : a.charAt(a.length() - i);
            char char2 = b.length() - i < 0 ? '0' : b.charAt(b.length() - i);
            int sum = (char1 - '0') + (char2 - '0') + carry;
            str.append(sum % 2);
            carry = sum / 2;
        }
        if(carry > 0){
            str.append(carry);
        }
        return str.reverse().toString();
    }

    /**
     * 58. 最后一个单词的长度
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if("".equals(s.trim())){
            return 0;
        }
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }

    /**
     * 557. 反转字符串中的单词 III
     * 输入: "Let's take LeetCode contest"    输出: "s'teL ekat edoCteeL tsetnoc"
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            for(int j = strs[i].length() - 1; j >= 0; j--){
                sb.append(strs[i].charAt(j));
            }
            if(i != strs.length -1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 459. 重复的子字符串
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     * 输入: "abab"  输出: True     输入: "aba"   输出: False
     * 如果您的字符串S包含一个重复的子字符串，那么这意味着您可以多次“移位和换行”您的字符串，并使其与原始字符串匹配。(移动1-（n-1）)
     * 例如:abcabc: 移位一次:cabcab; 移位两次:bcabca; 移位三次:abcabc;
     * 核心算法：所以可以直接判断str中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    /**
     * 面试题 01.09. 字符串轮转
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     * 输入：s1 = "waterbottle", s2 = "erbottlewat"    输出：True
     * 输入：s1 = "aa", s2 = "aba" 输出：False
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        return (s1 + s1).contains(s2);
    }

    /**
     * 1119. 删去字符串中的元音
     * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
     * 输入："leetcodeisacommunityforcoders"   输出："ltcdscmmntyfrcdrs"
     * 输入："aeiou"   输出：""
     * @param S
     * @return
     */
    public String removeVowels(String S) {
        Set<Character> sets = new HashSet(){{add('a');add('e');add('i');add('o');add('u');}};
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(!sets.contains(chars[i])){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 657. 机器人能否返回原点
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
     * 输入: "UD" 输出: true    解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        // 定义坐标原点
        int x = 0;
        int y = 0;
        char[] chars = moves.toCharArray();
        for(char ch : chars){
            if(ch == 'R'){
                y++;
            }else if(ch == 'L'){
                y--;
            }else if(ch == 'U'){
                x++;
            }else if(ch == 'D'){
                x--;
            }
        }
        return x == 0 && y == 0;
    }

    /**
     * 771. 宝石与石头
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *   J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *   输入: J = "aA", S = "aAAbbbb"    输出: 3           输入: J = "z", S = "ZZ"       输出: 0
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        // int res = 0;
        // for(int i = 0; i < S.length(); i++){
        //     if(J.contains(S.charAt(i) + "")){
        //         res++;
        //     }
        // }
        // return res;

        int res = 0;
        Set<Character> hash = new HashSet<>();
        for(int i = 0; i < J.length(); i++){
            hash.add(J.charAt(i));
        }
        for(int i = 0; i < S.length(); i++){
            if(hash.contains(S.charAt(i))){
                res++;
            }
        }
        return res;
    }

    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * 输入: s = "lrloseumgh", k = 6      输出: "umghlrlose"
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        String head = s.substring(0, n);
        String tail = s.substring(n);
        return tail + head;
    }

    /**
     * 151. 翻转字符串里的单词
     * 剑指 Offer 58 - I. 翻转单词顺序
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 输入: "the sky is blue"    输出: "blue is sky the"
     * 输入: "  hello world!  "   输出: "world! hello"      解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 输入: "a good   example"   输出: "example good a"    解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 1.无空格字符构成一个单词。
     * 2.输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 3.如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        s = s.trim();
        if("".equals(s)){
            return "";
        }
        while (s.contains("  ")) {
            s = s.replaceAll("  ", " ");
        }
        String[] strs = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--){
            ans.append(strs[i]).append(" ");
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
       /* s = s.trim();
        if("".equals(s)){
            return "";
        }
        int start = 0;
        int end = 0;
        String ans = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(' ' != s.charAt(i)){
                end++;
            }else{
                if(start != end) {
                    sb.insert(0, " " + s.substring(start, end));
                }
                end++;
                start = end;

            }
        }
        if(start != end) {
            sb.insert(0, " " + s.substring(start, end));
        }
        ans = sb.substring(1);
        return ans;*/
    }

    /**
     * 434. 字符串中的单词数
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。请注意，你可以假定字符串里不包括任何不可打印的字符。
     * 输入: "Hello, my name is John"     输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        s = s.trim();
        if(s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int ans = 0;
        for(int i = 0; i < chars.length; i++){
            if((i < chars.length - 1 && (chars[i] != ' ' && chars[i + 1] == ' '))
                    || (i == chars.length - 1 && chars[i] != ' ')){
                ans++;
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

    /**
     * 1446. 连续字符
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。请你返回字符串的能量。
     * 输入：s = "leetcode"    输出：2    解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
     * 输入：s = "abbcccddddeeeeedcba" 输出：5    解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
     * 输入：s = "triplepillooooow"    输出：5
     * @param s
     * @return
     */
    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        int ans = 1;
        int start = 0;
        int end = 1;
        while(end < chars.length){
            if(chars[start] == chars[end]){
                ans = Math.max(end - start + 1, ans);
                end++;
            }else{
                start = end;
                end++;
            }
        }
        return ans;
    }

    /**
     * 541. 反转字符串 II
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * 输入: s = "abcdefg", k = 2    输出: "bacdfeg"
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        // 每个k个字符转换k个字符
        char[] chars = s.toCharArray();
        char temp = 0;
        for(int i = 0; i < chars.length; i += 2 * k){
            int left = i;
            int right = i + k - 1 < chars.length ? i + k - 1 : chars.length - 1;
            while(left < right){
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    /**
     * 面试题 01.06. 字符串压缩
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * 输入："aabcccccaaa" 输出："a2b1c5a3"
     * 输入："abbccd" 输出："abbccd" 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     * @param S
     * @return
     */
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        if(S.equals("")){
            return S;
        }
        char cur = S.charAt(0);
        int num = 1;
        sb.append(cur + "");
        for(int i = 1; i < S.length(); i++){
            if(S.charAt(i) == cur){
                num++;
            }else{
                sb.append(String.valueOf(num));
                sb.append(S.charAt(i) + "");
                num = 1;
                cur = S.charAt(i);
            }
        }
        sb.append(String.valueOf(num));
        if(S.length() <= sb.length()){
            return S;
        }else{
            return sb.toString();
        }
        /*Stack<String> stack = new Stack();
        int num = 0;
        for(int i = 0; i < S.length(); i++){
            if(stack.isEmpty()){
                stack.push(S.charAt(i) + "");
                num++;
            }else if((S.charAt(i) + "").equals(stack.peek())){
                num++;
            }else{
                stack.push(String.valueOf(num));
                stack.push(S.charAt(i) + "");
                num = 1;
            }
        }
        stack.push(String.valueOf(num));
        if(S.length() <= stack.size()){
            return S;
        }else{
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                if(sb.length() == 0){
                    sb.append(stack.pop());
                }else{
                    sb.insert(0, stack.pop());
                }
            }
            return sb.toString();
        }*/
    }

    /**
     * 917. 仅仅反转字母
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     * 输入："ab-cd"   输出："dc-ba"
     * 输入："Test1ng-Leet=code-Q!"    输出："Qedo1ct-eeLg=ntse-T!"
     * 输入："a-bC-dEf-ghIj"   输出："j-Ih-gfE-dCba"
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        char temp;
        int start = 0;
        int end = S.length() - 1;
        char[] chars = S.toCharArray();
        while (start < end){
            if(isLetter(chars[start]) && isLetter(chars[end])){
                temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }else if(!isLetter(chars[start]) && isLetter(chars[end])){
                start++;
                continue;
            }else if(isLetter(chars[start]) && !isLetter(chars[end])){
                end--;
                continue;
            }else{
                start++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
        }
        return sb.toString();
        /*Set<Character> sets = new HashSet(){{
            add('a');add('b');add('c');add('d');add('e');add('f');add('g');add('h');
            add('i');add('j');add('k');add('l');add('m');add('n');add('o');add('p');
            add('q');add('r');add('s');add('t');add('u');add('v');add('w');add('x');
            add('y');add('z');
            add('A');add('B');add('C');add('D');add('E');add('F');add('G');add('H');
            add('I');add('J');add('K');add('L');add('M');add('N');add('O');add('P');
            add('Q');add('R');add('S');add('T');add('U');add('V');add('W');add('X');
            add('Y');add('Z');}};
        char temp;
        int start = 0;
        int end = S.length() - 1;
        char[] chars = S.toCharArray();
        while (start < end){
            if(sets.contains(chars[start]) && sets.contains(chars[end])){
                temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }else if(!sets.contains(chars[start]) && sets.contains(chars[end])){
                start++;
                continue;
            }else if(sets.contains(chars[start]) && !sets.contains(chars[end])){
                end--;
                continue;
            }else{
                start++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
        }
        return sb.toString();*/

        // A-Z 65-90; a-z 97-122
        //((chars[start] - 'A' >= 0 && chars[start] - 'A' <= 25) || (chars[start] - 'A' >= 32 && chars[start] - 'A' <= 57))
    }

    public static boolean isLetter(char letter){
        return (letter - 'A' >= 0 && letter - 'A' <= 25) || (letter - 'a' >= 0 && letter - 'a' <= 25);
    }

    /**
     * Linux语法简化规则(字节 13题的变种)
     * /c/d/////././../e/
     * /c/d/././../e/
     * /c/e
     * @param orignalStr
     * @return
     */
    public static String linuxRules(String orignalStr){
        while(orignalStr.contains("//")){
            orignalStr = orignalStr.replaceAll("//", "/");
        }
        char[] chars = orignalStr.toCharArray();
        String targetStr = "";
        for(int i = 0; i < chars.length ; i++){
            switch (chars[i]){
                case '/':
                    if(chars.length > 1 && i != chars.length - 1){
                        switch (chars[i + 1]){
                            case '.':
                                if(chars.length > 2 && i != chars.length - 2){
                                    switch (chars[i + 2]) {
                                        case '.':
                                            i += 2;
                                            int lastIndex = targetStr.lastIndexOf("/");
                                            if (lastIndex > 0) {
                                                targetStr = targetStr.substring(0, lastIndex);
                                            }
                                            break;
                                        default: // 以/.
                                            i++;
                                            break;
                                    }
                                    break;
                                }else {// 以/.结束的
                                    i++;
                                    break;
                                }
                            default:
                                targetStr += chars[i];
                                break;
                        }
                    }
                    break;
                default:
                    targetStr += chars[i];
                    break;
            }
        }
        return targetStr;
    }
}
