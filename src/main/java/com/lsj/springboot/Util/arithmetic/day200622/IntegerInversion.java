package com.lsj.springboot.Util.arithmetic.day200622;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 题目七:整数反转
 *
 * 题目九:回文数
 *
 * 题目13:罗马数字转整数
 *
 * 题目14:最长公共前缀
 *
 * 题目15:查找正确的括号
 *
 * 题目21:合并两个有序链表
 *
 * 题目26:删除排序数组中的重复项
 *
 * 题目27:移除元素
 */
public class IntegerInversion {

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
    }

    /**
     * 1.整数反转
     * 1234->4321; -123->-321; 1200->21; 1301->1031
     * int 的存储范围 [−2^31,  2^31 − 1],如果反转后整数溢出那么就返回 0。
     * @param orignal
     * @return
     */
    public static int integerInversion(int orignal){
        long target = 0;
        while(orignal != 0){
            target = target * 10 + orignal % 10;
            orignal /= 10;
        }
        if(target > (1L<<31) - 1 || target < -(1L<<31))
            return 0;
        return (int)target;
    }

    // 获取整数的个数
    private static int getIntegerNum(int inter){
        int integerNum = 0;
        for(int i = 1; ;i++) {
            inter = inter / 10;
            if(inter == 0){
                integerNum = i;
                break;
            }
        }
        return integerNum;
    }

    /**
     * 2.是否是回文数：借助整数反转的思路，判断反转前与反转后的值是否相等
     * 121->true;
     * 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * @param orignal
     * @return
     */
    public static boolean isPalindrome(int orignal){
        if(orignal < 0){
            return false;
        }
        int target = integerInversion(orignal);
        return target == orignal;
    }

    /**
     * 3.罗马数字转整数
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
     * 4.Linux语法简化规则
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
     * 5.查找字符串数组中的最长公共前缀
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

          /*  char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();
            int minLength = Math.min(firstChars.length, secondChars.length);
            char[] commonChars = new char[minLength];

            for(int j = 0; j < minLength; j++){
                if(firstChars[j] != secondChars[j]){
                    break;
                }
                commonChars[j] = firstChars[j];
            }
            */
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
     * 6.寻找正确的括号
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
        return false;
*/
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
     * 7.合并两个有序链表
     * 将2个升序链表合并为一个新的升序链表并返回
     * 1->5->6, 1->3->4->6
     * @param firstList
     * @param secondList
     * @return
     */
    public static Integer[] combine(Integer[] firstList, Integer[] secondList){
        if(firstList == null || firstList.length == 0){
            return secondList;
        }else if(secondList == null || secondList.length == 0){
            return firstList;
        }
        List<Integer> combine = new ArrayList<>();
        for(int i = 0, j = 0; i < firstList.length && j < secondList.length;){
            int first = firstList[i];
            int second = secondList[j];
            if(first == second){
                combine.add(first);
                i++;j++;
            }else {
                int max = Math.max(first, second);
                if(first == max){
                    combine.add(second);
                    j++;
                }else if(second == max){
                    combine.add(first);
                    i++;
                }
            }
        }
        return combine.toArray(new Integer[combine.size()]);
    }

    /**
     * 8.删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复的数组，使得每一个元素只出现一次，返回新数组的长度
     * 不要使用额外的数组空间，并在原地修改输入数组  元素的顺序可以改变
     * nums{0,0,1,1,1,2,2,3,3,4}
     * 快慢指针
     * @param original
     * @return
     */
    private static int deleteCommonItem(Integer[] original){
        if(original == null){
            return 0;
        }else if(original.length < 2){
            return original.length;
        }
        int cur = 0;
        for(int i = 1; i < original.length; i++){
            if(original[cur] != original[i]){
                original[++cur] = original[i];
            }
        }
        return (cur + 1);
    }
    /**
     * 9.移除元素
     * 给定一个排序数组nums和一个值val，你需要在原地删除值等于val的元素，返回新数组的长度
     * 不要使用额外的数组空间，并在原地修改输入数组 元素的顺序可以改变
     * nums{3,2,3,1,4,5,3,2,1}
     * 快慢指针
     * @param original
     * @return
     */
    private static int deleteAssignItem(Integer[] original, int target){
        if(original == null){
            return 0;
        }else if(original.length < 2){
            return original.length;
        }
        int cur = 0;
        for(int i = 0; i < original.length; i++){
            if(original[i] != target){
                original[cur++] = original[i];
            }
        }
        return cur;
    }

    /**
     * 10.实现indexOf(),
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
        int num = 0;
        int index = -1;
        // 1.滑动窗口
        for(int i = 0; i <= orignalChar.length - findChar.length; i++){
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




}
