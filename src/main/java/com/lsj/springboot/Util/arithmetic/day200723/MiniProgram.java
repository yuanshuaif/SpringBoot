package com.lsj.springboot.Util.arithmetic.day200723;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 题目3：无重复字符的最长子串
 * abcabcbb 最长字串abc; bbbbb 最长字串b; pwwkew 最长字串wke
 * 滑动窗口
 *
 * 题目5：最长回文字串
 * 滑动窗口暴力破解、动态规划
 *
 * 495.中毒总时长
 * 数组的遍历
 *
 * 509.斐波那契数
 * 递归
 *
 * 1071.字符串的最大公因子
 * 辗转相除法
 *
 * 836. 矩形重叠
 * 将矩形相不相交的问题，转化为x,y轴上2条线相不相交的问题
 *
 * 392. 判断子序列
 * 入栈法
 *
 * 409. 最长回文串
 *

 */
public class MiniProgram {

    public static void main(String[] args){
       /* System.out.println(longest("abcabcbb"));
        System.out.println(longest("bbbbb"));
        System.out.println(longest("pwwkew"));*/

        /*System.out.println(longestPalindromeStr("babad"));
        System.out.println(longestPalindromeStr("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));*/

//        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
//        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
      /*  int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        System.out.println(isRectangleOverlap(rec1, rec2));*/
       /* 输入: A = [1,2,3,0,0,0], m = 3;  B = [2,5,6],  n = 3
      输出: [1,2,2,3,5,6]*/
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
/*
         // 耗时587毫秒
        long startTime = System.currentTimeMillis();
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
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return palindromeStr;*/

        // 耗时17毫秒
       /* long startTime = System.currentTimeMillis();
        String palindromeStr = "";
        char[] chars = str.toCharArray();
        int len = chars.length;
        for(int i = 0; i < len; i++){
            int start = 0;
            int end = len - i;
            while(end <= str.length()) {
                if(isPalindromeStr(chars, start, end - 1)){
                    palindromeStr = str.substring(start, end);
                    break;
                }
                start++;
                end++;
            }
            if(!StringUtils.isEmpty(palindromeStr)){
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return palindromeStr;

        */
       // 动态规划
        int len = str.length();
        if(len < 2){
            return str;
        }
        char[] chars =  str.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        int start = 0;
        int maxlength = 1;
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxlength){
                    maxlength = j - i + 1;
                    start = i;
                }
            }
        }
        return str = str.substring(start, start + maxlength);
    }

    private static boolean isPalindromeStr(char[] chars, int start, int end){
        while(start < end){
            if(chars[start] != chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 509斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0,   F(1) = 1     F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * @param N
     * @return
     */
    public int fib(int N) {
        // 递归
//        if(N < 2){
//            return N;
//        }
//        return fib(N - 1) + fib(N - 2);
        if(N < 2){
            return N;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i = 2; i <= N; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    /**
     * 字符串的最大公因子
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

    // 日期相隔天数
    //    输入：date1 = "2019-06-29", date2 = "2019-06-30"     输出：1
    //    输入：date1 = "2020-01-15", date2 = "2019-12-31"     输出：15
    public static int daysBetweenDates(String date1, String date2) {
        long time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            time = sdf.parse(date1).getTime() - sdf.parse(date2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long nd = 1000 * 24 * 60 * 60;
        int day = Integer.valueOf(String.valueOf(time / nd));
        return day < 0 ? -day : day;
    }

  /*  836. 矩形重叠
    矩形如果不重叠，从x轴和y轴上看两个矩形就变成了两条线段，这两条线段肯定是不相交的，
    也就是说左边的矩形的最右边小于右边矩形的最左边， 也就是rec1[2] < rec2[0] || rec2[2] < rec1[0]；
    y轴同理，下面的矩形的最上边小于上面矩形的最下边，也就是rec1[3] < rec2[1] || rec2[3] < rec1[1]*/
//    [7,8,13,15][10,8,12,20]
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !((rec1[2] <= rec2[0] || rec2[2] <= rec1[0]) || (rec1[3] <= rec2[1] || rec2[3] <= rec1[1]));
    }


    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     示例 1:s = "abc", t = "ahbgdc"    返回 true.
     示例 2:s = "axc", t = "ahbgdc" 返回 false.
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        // 入栈法 将t字节压入到栈里，取出来与s的字节匹配，
        //若结束后，s字节没有值是子序列，若有值不是子序列
        Stack<Character> st =new Stack<>();
        for(char ch : t.toCharArray()){
            st.push(ch);
        }
        int compile = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(!st.isEmpty()){
                char pop = st.pop();
                while(!st.isEmpty() && s.charAt(i) != pop){
                    pop = st.pop();
                }
                if(s.charAt(i) == pop){
                    compile++;
                }
            }
        }

        return compile == s.length();
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
     * 70.爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 类似于斐波那契数
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n < 2){
            return n;
        }
        // 初始化
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;

        for(int i = 2; i <= n; i++){
            ints[i] = ints[i - 2] + ints[i - 1];
        }
        return ints[n];
    }

}
