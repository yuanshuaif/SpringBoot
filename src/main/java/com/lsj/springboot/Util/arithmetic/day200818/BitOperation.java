package com.lsj.springboot.Util.arithmetic.day200818;

/**
 * Created by 10326 on 2020/8/22.
 *
 * 371. 两整数之和
 *
 * 61. 汉明距离
 */
public class BitOperation {

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
        示例 1:    输入: a = 1, b = 2   输出: 3
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        /*第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
        第二步：计算进位值，得到1010，相当于各位进行与操作得到101，再向左移一位得到1010，(101&111)<<1。
        第三步重复上述两步，各位相加 010^1010=1000，进位值为100=(010 & 1010)<<1。
        继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
        结束条件：进位为0，即a为最终的求和结果。*/
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    /**
     * 461. 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。注意：  0 ≤ x, y < 231.
     * 输入: x = 1, y = 4  输出: 2
     * 解释:
     *   1   (0 0 0 1)
     *   4   (0 1 0 0)
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int a = x ^ y;// 0 1 0 1
        int start = 0;
        while(a != 0){
            if((a & 1) == 1){
                start++;
            }
            a = a >> 1;
        }
        return start;
    }

}
