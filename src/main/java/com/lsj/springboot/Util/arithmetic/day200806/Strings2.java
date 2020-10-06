package com.lsj.springboot.Util.arithmetic.day200806;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * 1446. 连续字符
 *
 * 面试题 01.02. 判定是否互为字符重排
 *
 * 面试题 01.09. 字符串轮转
 *
 * 917. 仅仅反转字母
 *
 * 434. 字符串中的单词数
 *
 * 151. 翻转字符串里的单词
 *
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * 657. 机器人能否返回原点
 *
 * 771. 宝石与石头
 *
 * 剑指 Offer 58 - II. 左旋转字符串
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
     * 917. 仅仅反转字母
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     * 输入："ab-cd"   输出："dc-ba"
     * 输入："Test1ng-Leet=code-Q!"    输出："Qedo1ct-eeLg=ntse-T!"
     * 输入："a-bC-dEf-ghIj"   输出："j-Ih-gfE-dCba"
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
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
    }

    public static boolean isLetter(char letter){
        return (letter - 'A' >= 0 && letter - 'A' <= 25) || (letter - 'a' >= 0 && letter - 'a' <= 25);
    }

    /**
     * 434. 字符串中的单词数
     * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。请注意，你可以假定字符串里不包括任何不可打印的字符。
     * 输入: "Hello, my name is John"     输出: 5
     * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
     *
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
        return ans;
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

    public static void main(String[] args){
//        System.out.println(validPalindrome("lcuppucul") );
//        System.out.println(maxPower("t") );
//        System.out.println(CheckPermutation("abc", "bca") );
//        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!") );
//        System.out.println(countSegments(", , , ,        a, eaefa") );

        System.out.println(reverseWords("the sky is blue") );

    }
}
