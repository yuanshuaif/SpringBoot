package com.lsj.springboot.Util.arithmetic.day200812;

/**
 * Created by 10326 on 2020/11/25.
 *
 * https://mp.weixin.qq.com/s/_B9y97J1vM8dhdQJNq_F9w
 *
 * https://mp.weixin.qq.com/s/ZygPOjMMcwtOgLSVVzJlIw
 * 插入排序：直接插入排序和希尔排序两种(将数组分为有序、无序数组，依次将无序数组中的元素插入到有序数组中)
 *
 * https://mp.weixin.qq.com/s/QG5gmGHpqzNrkltVwbb0yQ
 * 交换排序：冒泡排序和快速排序（如果发现两个记录的次序相反时即进行交换，直到没有反序位置）
 *
 *
 */
public class SortAlgorithm2 {

    public static void main(String[] args){
       /* int[] array = new int[]{9, 3, 8, 7, 5, 9, 1, 2, 10, 9};
        sort4(array);*/

        int[] array = new int[]{11, 7, 1, 33, 2, 22};
        sort4(array);

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
     * 时间复杂度O(n3/2)
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

    /**
     * 3.冒泡排序
     * 通过相邻元素之间比较和交换，使较小移向顶部，从后往前两两比较。
     * 时间复杂度：O(n^2) 空间复杂度：O(1)  稳定性：稳定
     * @param arrays
     */
    private static void sort3(int[] arrays){
        int temp;
        for(int i = 1; i < arrays.length; i++){// 控制循环次数
            for(int j = 0; j < arrays.length - i; j++){
                if(arrays[j] > arrays[j + 1]){
                    temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 4.快速排序
     * 是冒泡排序的改进，比较和交换从两端向中间进行。
     * 过程：
     * 1.设两个指针l和r，初值分别为low和high，基准为x=R[l]，
     * 2.首先从r位置开始向前搜索第一个小于基准x.key的记录存入l所指位置上，l自增1，
     * 3.然后从l所指位置向后搜索找到第一个大于基准x.key的记录存入r所指位置上，r自减1，
     * 4.重复直至l=r为止。
     * 5.将基准值付给R[l]或者R[r]
     * 6.左右进行递归
     * 时间复杂度：O(nlog2n)  空间复杂度：O(log2n)  稳定性：不稳定
     * @param arrays
     */
    private static void sort4(int[] arrays){
//        sort4(arrays, 0, arrays.length - 1);
        quickSort(arrays, 0, arrays.length - 1);
    }


    private static void sort4(int[] arrays, int left, int right){
        int l = left;
        int r = right;
        int x = arrays[l];
        while(l < r){
            while(l < r && arrays[r] > x){
                r--;
            }
            if(l < r){
                arrays[l++] = arrays[r];
            }
            while(l < r && arrays[l] < x){
                l++;
            }
            if(l < r){
                arrays[r--] = arrays[l];
            }
        }
        arrays[r] = x;// l == r 上述循环终止条件
        if(left < l){
            sort4(arrays, left, l - 1);
        }
        if(r < right){
            sort4(arrays, r + 1, right);
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        i = low;
        j = high;
        //基准位
        temp = arr[low];

        while (i < j) {
            //从右边开始，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //从左边开始，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        if(low < i) {
            quickSort(arr, low, j - 1);
        }
        if(j < high) {
            quickSort(arr, j + 1, high);
        }
    }


}