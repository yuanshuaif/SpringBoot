package com.lsj.springboot.Util.arithmetic.day200806;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by 10326 on 2020/8/9.
 *
 *  面试题 01.01. 判定字符是否唯一
 *
 *  题目13:罗马数字转整数
 *
 *  Linux语法简化规则(字节 13题的变种)
 *
 *  题目14:最长公共前缀
 *
 *  题目20:查找正确的括号
 *
 *  题目3:无重复字符的最长子串
 *  滑动窗口
 *
 *  题目5:最长回文字串
 *  滑动窗口暴力破解、动态规划
 *
 *  题目28:实现indexOf()
 *  滑动窗口
 *
 *  344. 反转字符串
 *  双指针
 *
 *  1071.字符串的最大公因子
 *  辗转相除法
 *
 *  409. 最长回文串
 *
 *  剑指 Offer 03. 数组中重复的数字
 *
 *  415. 字符串相加
 *  67. 二进制求和（思想同上）
 *
 *  58. 最后一个单词的长度
 *
 */
public class Strings {

    private static final Map<Character,Character> map = new HashMap(){{
        put('{','}'); put('[',']'); put('(',')');
    }};

    public static void main(String[] args){
     /*   System.out.println(integerInversion(-123));
        System.out.println(integerInversion(1534236469));*/
//        System.out.println(isPalindrome(-232));
//        System.out.println(roman2Int("MCMXCIV"));
      /*  System.out.println(linuxRules("/c/d/////././../e/."));
        System.out.println(linuxRules("/c/d/////././../e/"));
        System.out.println(linuxRules("/c/d/////././../e/.."));
        System.out.println(linuxRules("/c/d/////././../ed/.."));
        System.out.println(linuxRules("/c/d/////././../ed/."));*/
//        String[] strs = new String[]{"flower","flow","flight","flosh"};
//        System.out.println(longestCommonPrefix(strs));
        System.out.println( findRealParentheses("()[]{}"));
        System.out.println( findRealParentheses("))[]{}"));
        System.out.println( findRealParentheses("()[]{(}"));
        System.out.println( findRealParentheses("[()[]]{}"));
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

          /* System.out.println(longest("abcabcbb"));
        System.out.println(longest("bbbbb"));
        System.out.println(longest("pwwkew"));*/

        /*System.out.println(longestPalindromeStr("babad"));
        System.out.println(longestPalindromeStr("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));*/

        /*  int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        System.out.println(isRectangleOverlap(rec1, rec2));*/
       /* 输入: A = [1,2,3,0,0,0], m = 3;  B = [2,5,6],  n = 3
      输出: [1,2,2,3,5,6]*/
    }

    /**
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * 输入: s = "leetcode" 输出: false ;   输入: s = "abc"  输出: true
     * 不使用额外的数据结构
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
     * 罗马数字包含以下7种字符:I、V、X、L、C、D、M
     * 数字值I->1,V->5,X->10,L->50,C->100,D->500,M->1000
     * 例如：罗马数字2写作II,罗马数字27写作XXVII    LVIII->58   MCMXCIV->1994
     * 6个特殊情况：
     *      I放到 V和X的左边，表示4，9
     *      X放到 L和C的左边，表示40，90
     *      C放到 D和M的右边，表示400,900
     *
     * 给定一个罗马数字转化成整数（1-3999）
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
                                        default:
                                            i++;
                                            break;
                                    }
                                    break;
                                }else {
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

    /**
     * 14.查找字符串数组中的最长公共前缀
     * 如果不存在公共前缀，返回空字符串
     * 所有输入只包含小写字母a-z
     * 例如：输入{"flower","flow","flight","flosh"} 输出"fl"
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        String common = "";
        for(int i = 0; i < strs.length - 1; i++){
            String first = "";
            String second = "";
            if(StringUtils.isEmpty(common)){// 第一个跟第二个数取公共前缀
                first = strs[i];
                second = strs[i + 1];
            }else{
                first = common;
                second = strs[i + 1];
            }
            int minLength = Math.min(first.length(), second.length());
            StringBuffer commonChars = new StringBuffer();
            for(int j = 0; j < minLength; j++){
                if(first.charAt(j) != second.charAt(j)){
                    break;
                }
                commonChars = commonChars.append(first.charAt(j));
            }
            common = String.valueOf(commonChars);
            if(StringUtils.isEmpty(common)){
                break;
            }
        }
        return common;
    }

    /**
     * 20.寻找正确的括号
     * 给定一个括号的字符串，必须以正确的顺序闭合
     * ()[]{}  ([{}]) 分为并排、嵌套2种
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
        if("".equals(parentheses)){// 空串认为是有效字符串
            return true;
        }else if(parentheses.length() % 2 != 0){// 奇数直接返回
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = parentheses.toCharArray();
        if(!map.containsKey(chars[0])){
            return false;
        }
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                stack.push(chars[i]);
            }else{
                if(map.get(stack.isEmpty() ? '?' : stack.pop()) != chars[i]){
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
     * 28.实现indexOf(),
     * haystack = "hello", needle = "ll" 返回2；
     * haystack = "aaaa", needle = "bba" 返回-1;
     * needle = ""，返回0
     * 时间复杂度((N-L)L)
     * @param orignal
     * @param findStr
     */
    private static int indexOf(String orignal, String findStr){
        if(findStr == null || orignal == null){
            throw new RuntimeException("参数不能为空");
        }
        if("".equals(findStr)){
            return 0;
        }else if(findStr.length() > orignal.length() || "".equals(orignal)){
            return -1;
        }
        char[] orignalChar = orignal.toCharArray();
        char[] findChar = findStr.toCharArray();
        int index = -1;
        // 1.滑动窗口
        for(int i = 0; i <= orignalChar.length - findChar.length; i++){
            int num = 0;
            for(int j = 0; j < findChar.length; j++){
                if(orignalChar[i + j] != findChar[j]){
                    break;
                }else{
                    num++;
                }
            }
            if(num == findChar.length){
                index = i;
                break;
            }
        }
        return index;
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
     * 1071.字符串的最大公因子
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
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
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     输入: "abccccdd" 输出: 7
     解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
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
        num1 和num2 的长度都小于 5100
        num1 和num2 都只包含数字 0-9
        num1 和num2 都不包含任何前导零
        你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
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
}
