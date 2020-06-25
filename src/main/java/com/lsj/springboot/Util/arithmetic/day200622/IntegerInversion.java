package com.lsj.springboot.Util.arithmetic.day200622;

/**
 * 题目七
 * 整数反转
 * 1234->4321; -123->-321; 1200->21; 1301->1031
 */
public class IntegerInversion {

    public static void main(String[] args){
        System.out.println(integerInversion(-123));
    }

    public static int integerInversion(int orignal){
        int target = 0;
        while(orignal != 0){
            target = target * 10 + orignal % 10;
            orignal /= 10;
        }
        return target;
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
}
