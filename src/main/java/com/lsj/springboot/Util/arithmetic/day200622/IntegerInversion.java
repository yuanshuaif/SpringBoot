package com.lsj.springboot.Util.arithmetic.day200622;

/**
 * 题目七
 * 整数反转
 * 1234->4321; -123->-321; 1200->21; 1301->1031
 *
 * 题目九
 * 回文数
 * 121->true; -232->true
 *
 * 题目13
 * 罗马数字转整数
 */
public class IntegerInversion {

    public static void main(String[] args){
        System.out.println(integerInversion(-123));
        System.out.println(isPalindrome(-232));
        System.out.println(roman2Int("MCMXCIV"));
    }

    /**
     * 整数反转
     * @param orignal
     * @return
     */
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


    /**
     * 是否是回文数：借助整数反转的思路，判断反转前与反转后的值是否相等
     * @param orignal
     * @return
     */
    public static boolean isPalindrome(int orignal){
        int target = integerInversion(orignal);
        return target == orignal;
    }

    /**
     * 罗马数字转整数
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
        for(int i = 0; i < chars.length - 1; i++){
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
                        i++;
                        switch (chars[i]) {
                            case 'V':
                                target += 4;
                                break;
                            case 'X':
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
                        i++;
                        switch (chars[i]) {
                            case 'L':
                                target += 40;
                                break;
                            case 'C':
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
                        i++;
                        switch (chars[i]) {
                            case 'D':
                                target += 400;
                                break;
                            case 'M':
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
}
