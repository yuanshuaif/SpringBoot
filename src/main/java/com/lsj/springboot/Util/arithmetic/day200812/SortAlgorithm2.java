package com.lsj.springboot.Util.arithmetic.day200812;

/**
 * Created by 10326 on 2020/11/25.
 *
 * https://mp.weixin.qq.com/s/_B9y97J1vM8dhdQJNq_F9w
 *
 * https://mp.weixin.qq.com/s/ZygPOjMMcwtOgLSVVzJlIw
 * 插入排序：直接插入排序和希尔排序两种
 *
 *
 */
public class SortAlgorithm2 {

    public static void main(String[] args){
        int[] array = new int[]{9, 3, 8, 7, 4, 5, 1, 2, 10};
        sort2(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 1.直接插入排序
     * 每次从无序区取出第一个元素把它插入到有序区的适当位置，使之成为新的有序区，经过n-1次插入后完成。
     * 时间复杂度：最好是O(n)，最坏是O(n^2)  空间复杂度：O(1)   属于稳定算法。
     */
    private static void sort1(int[] arrays){
        int temp;
        int j;
        for(int i = 1; i < arrays.length; i++){
            temp = arrays[i];//手牌
            j = i - 1;// 手牌前一个值
            while(j >= 0 && arrays[j] > temp){
                arrays[j + 1] = arrays[j];
                j--;
            }
            arrays[j + 1] = temp;
        }
    }

    /**
     * 2.希尔排序
     * 把待排序的数据元素分成若干个小组，对同一小组内的数据元素用直接插入排序进行排序；
     * 小组的个数逐次缩小，当完成了所有的数据元素都在一个小组内的排序后，排序过程结束。所以希尔排序又称作缩小增量排序。
     * 希尔排序的前提是在直接插入排序之上，是对直接插入排序的一个升级版。属于不稳定算法。
     * @param arrays
     */
    private static void sort2(int[] arrays){
        int temp;
        int j;
       /* 1.将n个元素分成n/2个数组序列，第一个元素与n/2+1为一对
        * 2.每一次循环使每一个序列都排好顺序
        * 3.再变成n/4个序列进行排序
        * 4.不断重复上述过程，直到序列减少成1个*/
        for(int k = arrays.length / 2; k >= 1; k /= 2) {
            for (int i = k; i < arrays.length; i++) {
                temp = arrays[i];//手牌
                j = i - k;// 手牌前一个值
                while (j >= 0 && arrays[j] > temp) {
                    arrays[j + k] = arrays[j];
                    j -= k;
                }
                arrays[j + k] = temp;
            }
        }
    }

}