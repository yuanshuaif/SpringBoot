package com.lsj.springboot.Util.arithmetic.day200622;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 题目七:整数反转
 *
 * 题目九:回文数
 *
 * 509斐波那契数
 *
 * 836. 矩形重叠
 * 将矩形相不相交的问题，转化为x,y轴上2条线相不相交的问题
 *
 */
public class Integers {

    public static void main(String[] args){
//        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
//        System.out.println(daysBetweenDates("2020-01-15", "2019-12-31"));
    }

    /**
     * 7.整数反转
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
    /**
     * 9.是否是回文数：借助整数反转的思路，判断反转前与反转后的值是否相等
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
}
