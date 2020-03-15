package com.lsj.springboot.Util.BinarySortTree;

import java.util.Arrays;

/**
 * Created by 10326 on 2020/3/15.
 */
public class BinarySearch {

    private static int[] list = new int[]{8,5,12,98,53,22,65,21,75,89,32,21};

    public static void main(String[] args){
        System.out.println(search(list, 65));
    }

    public static int search(int[] array, int value){
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == value) {
                return value;
            } else if (array[mid] > value) {
                end = mid - 1;
            } else if (array[mid] < value) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
