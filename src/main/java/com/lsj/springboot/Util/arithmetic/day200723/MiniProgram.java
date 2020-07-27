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
 * 题目11. 盛最多水的容器
 * 双指针
 *
 * 485. 最大连续1的个数
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
 * 10.01. 合并排序的数组
 * 利用归并排序进行merge
 *
 * 392. 判断子序列
 * 入栈法
 *
 * 409. 最长回文串
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
        int[] A = {1,2,3,0,0,0};
        int m = 3;
        int[] B = {2,5,6};
        int n = 3;
        merge(A, m, B, n);
        System.out.println(A);
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
     * 数组的遍历
     * 485. 最大连续1的个数
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * 输入: [1,1,0,1,1,1]  输出: 3
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                temp++;
            }else{
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        if(temp != 0){
            max = Math.max(max, temp);
        }
        return max;
    }

    /**
     * 495.中毒总时长
     * 输入: [1,4], 2  输出: 4
         原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
         第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
         所以最终输出 4 秒。
       输入: [1,2], 2 输出: 3
         原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
         但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
         由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
         所以最终输出 3 。
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0){
            return 0;
        }
        int total = 0;
        for(int i = 0; i < timeSeries.length - 1; i++){
            // if(timeSeries[i] + duration < timeSeries[i + 1]){
            //     total += duration;
            // } else{
            //     total += timeSeries[i + 1] - timeSeries[i];
            // }
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        total += duration;
        return total;
    }

    /**
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
     * 10.01. 合并排序的数组
     * 输入: A = [1,2,3,0,0,0], m = 3;  B = [2,5,6],  n = 3 输出: [1,2,2,3,5,6] 先将A数组中的m个元素移动到末尾；
     * 然后利用归并排序的merge思想，每次取出A和B数组头元素中的最小值逐个放到A数组中。
     * 以上说法有点抽象，我们举个例子吧。假设A = [1,2,3,0,0,0], B = [2,5,6] A=[1,2,3,0,0,0],B=[2,5,6]。A数组元素的变化过程如下：
     * [0,0,0,1,2,3][1,0,0,1,2,3][1,2,0,0,0,3][1,2,2,0,0,3][1,2,2,3,0,0][1,2,2,3,5,0][1,2,2,3,5,6]
     * 说明：以上元素被移动到正确的位置上后，其实无需置0（为了演示看起来更加直观，置0）。
     * @param A
     * @param m
     * @param B
     * @param n
     */
   public static void merge(int[] A, int m, int[] B, int n) {
      /* public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        Object src : 原数组
        int srcPos : 从元数据的起始位置开始
    　　Object dest : 目标数组
    　　int destPos : 目标数组的开始起始位置
    　　int length  : 要copy的数组的长度*/
       // 先将A右移到末尾
       System.arraycopy(A, 0, A, n, m);
       int index = 0;
       int indexA, indexB;
       // 归并排序 merge
       for(indexA = n, indexB = 0; indexA < m + n && indexB < n;){
           if(A[indexA] >= B[indexB]){
               A[index++] = B[indexB++];
           }else{
               A[index++] = A[indexA++];
           }
       }
       // A中还有剩余元素
       while(indexA < m + n){
           A[index++] = A[indexA++];
       }
       // B中还有剩余元素
       while(indexB < n){
           A[index++] = B[indexB++];
       }
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

}
