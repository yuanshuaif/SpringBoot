package com.lsj.springboot.Util.arithmetic.day200812;

/**
 * Created by 10326 on 2020/2/10.
 * 排序算法
 * 基本排序算法：交换排序：冒泡排序；选择排序：选择排序、堆排序；插入排序：插入排序、Shell排序；合并排序、桶排序
 */
public class SortAlgorithm {
    private static Integer[] integers = new Integer[]{31, 12, 23, 34, 43, 13, 37, 9};

    private static int count = 0; //统计一下次数

    public static void main(String[] args){
//        test1();
//        test2();
//        test3();
//        test4();
        test5(0, integers.length - 1);
    }

    /**
     * 1.冒泡排序 时间复杂度o(n^2)  空间复杂度o(n^2)
     */
    public static void test1(){
        // 1.需要进行n-1次循环比较
        for(int i = 1; i < integers.length; i++){
            // 2.第i次循环，需要n-i次比较
            for(int j = 0; j < integers.length -i; j++){
                // 3.如果前面的值大于后面的值大于前面的值，则进行交换
                if (integers[j] > integers[j + 1]){
                    int temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;
                }
            }
        }
        system();
    }


    /**
     * 2.选择排序：时间复杂度o(n^2)  空间复杂度o(n)
     *   1.选择最小的元素与第一个元素交换；
     *   2.选择第二小的元素与第二个元素交换；
     *   3.重复上述过程，直到最后两个元素交换完毕
     */
    public static void test2(){
        int min;
        // 1.需要进行n-1次循环
        for(int i = 0; i < integers.length -1; i++){
            min = i;// 2.设第i次循环的第一个值为最小值
            // 3.从后面一个元素一直到最后一个元素，循环与该元素进行比较，并修改最小值的下标
            for(int j = i + 1; j < integers.length; j++){
                if (integers[min] > integers[j]) {
                    min = j;
                }
            }
            // 4.如果最小值与第一个元素的值不一样，转换2者的位置
            if(i != min){
                int temp = integers[min];
                integers[min] = integers[i];
                integers[i] = temp;
            }
        }
        system();
    }

    /**
     * 3.插入排序   时间复杂度o(n^2)  空间复杂度o(n)
     * 前n-1个元素是有序的，第n个元素插入到n-1个元素中对应的位置上
     */
    public static void test3(){
        int temp;
        int j;
        //1. 需要进行n-1次循环
        for(int i = 1; i < integers.length; i++){
            temp = integers[i];// 手牌
            j = i - 1;// 2.手牌从前一个元素开始进行比较
            while(j >= 0 &&  temp < integers[j]){// 手牌小于前一个数，j--，手牌继续与前面的进行比较，直到j=0
                integers[j + 1] = integers[j];
                j--;
            }
            integers[j + 1] = temp;
        }
        system();
    }

    /**
     * 4.shell排序（对插入排序的优化） 时间复杂度O(n3/2)
     * 1.将n个元素分成n/2个数组序列，第一个元素与n/2+1为一对
     * 2.每一次循环使每一个序列都排好顺序
     * 3.再变成n/4个序列进行排序
     * 4.不断重复上述过程，直到序列减少成1个
     */
    private static void test4(){
        int temp;
        int k;
        // 1.按照shell排序的规则写第一层循环
        for(int i = integers.length/2; i >= 1; i = i/2){
            // 后面进行插入排序(如果把i变成1，后面的代码与插入排序一毛一样)
            for(int j = i; j < integers.length; j++){
                // i代表序列中2个元素的间隔
                temp = integers[j];
                k = j - i;
                while(k >= 0 && temp < integers[k]){
                    integers[k + i] = integers[k];
                    k -= i;
                }
                integers[k + i] = temp;
            }
        }
        system();
    }


    /**
     * 5.快速排序(对冒泡排序的优化) 时间复杂度nlogn
     * @param left
     * @param right
     */
    public static void test5(int left, int right){
        // 31, 12, 23, 34, 43, 13, 37, 9
        // 31, 12, 23, 34, 43, 13, 37, 9, 35
        int fleft = left,fright = right,temp;
        int t = integers[(fleft + fright) / 2]; //0.取一个分界值
        //1.把小于分界值的移动到左边；把大于分界值的移动到右边
        while(fleft < fright){
            while(integers[fleft] < t){
                fleft++;
            }
            while(integers[fright] > t){
                fright--;
            }
            // 特殊场景1.fleft=fright-1（偶数）; 2.fleft=fright-2(后面特殊处理)(奇数)
            if(fleft < fright){
                temp = integers[fleft];
                integers[fleft] = integers[fright];
                integers[fright] = temp;
                fleft++;
                fright--;
            }
        }
        if(fleft == fright){
            if(integers[fleft] <= t){// 把未比较的那个值归于左边
                fleft++;
            }else if(integers[fleft] > t){//把未比较的值归于右边
                fright--;
            }
        }

        if(left < fright){// 2.递归左侧区域
            test5(left, fleft - 1);
        }
        if(right > fleft){// 2.递归右侧区域
            test5(fright + 1, right);
        }
        System.out.println(++count + "------------");
        system();
    }

    private static void system(){
        for (Integer integer:
                integers ) {
            System.out.println(integer);
        }
    }


}