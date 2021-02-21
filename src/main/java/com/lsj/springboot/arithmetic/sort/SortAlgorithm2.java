package com.lsj.springboot.arithmetic.sort;

import java.util.Arrays;

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
 * https://mp.weixin.qq.com/s?__biz=MzIwNDgxNDM0MQ==&mid=2247488326&idx=1&sn=588db1a91cf33a180dc074a80688e1a5&chksm=973b322ca04cbb3a6037850c5bd6dc876011f17a3c2eca62392ad724a85f9512fc3f2b0758f1&scene=21#wechat_redirect
 * 选择排序：直接选择排序和堆排序(每一趟从待排序的记录中选出关键字最小的记录，顺序放在已排好序的子文件的最后，直到全部记录排序完毕)
 *
 * https://mp.weixin.qq.com/s?__biz=MzIwNDgxNDM0MQ==&mid=2247488381&idx=1&sn=cda39697c65cd7d567982fe122dd00b5&chksm=973b3217a04cbb01539e3545617243f43118ebba533bffd0e1022f45d9c225d56fc14e78c715&scene=21#wechat_redirect
 * 归并排序：（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *
 * https://mp.weixin.qq.com/s?__biz=MzIwNDgxNDM0MQ==&mid=2247488426&idx=1&sn=dd45be7db35c0184359451dc22004c95&chksm=973b32c0a04cbbd619417c97b60c6b6721db22aac8014ed11e0e09be71271b7d99f1a12d06b4&scene=21#wechat_redirect
 * 分配排序：桶排序和基数排序
 *
 */
public class SortAlgorithm2 {

    public static void main(String[] args){
        int[] array = new int[]{9, 3, 8, 7, 5, 1, 2, 10, 9};
        array = sort8(array);

       /* int[] array = new int[]{11, 7, 1, 33, 2, 22};
        sort5(array);*/

   /*     int[] array = new int[]{10, 15, 56, 25, 30, 70};
        sort(array);*/

     /*   int[] array = new int[]{4, 154, 56, 5, 34, 75};
        sort9(array);*/

      /*  int[] array = new int[]{9, 3, 9, 7, 5, 1, 2, 10, 9};
        sort4(array);*/

       /* int[] array = new int[]{43, 13, 91, 23, 24, 16, 5, 88};
        sort6(array);*/
/*
        int[] array = new int[]{43, 13, 91, 23, 24, 16, 5, 88};
        array = sort7(array);*/

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
        // 9, 3, 9, 7, 5, 1, 2, 10, 9
        int l = left;
        int r = right;
        int x = arrays[l];
        while(l < r){
            while(l < r && arrays[r] >= x){// >
                r--;
            }
            if(l < r){
                arrays[l++] = arrays[r];
            }
            while(l < r && arrays[l] <= x){// <
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

    /**
     * 5.直接选择排序
     * 数组分成有序区和无序区，初始时整个数组都是无序区，然后每次从无序区选一个最小的元素直接放到有序区的最后，直到整个数组变有序区。
     * 注意，第1趟排序开始时，无序区为R[1..n]，有序区为空。
     *
     * 第i趟排序开始时，当前有序区和无序区分别为R[1..i-1]和R[i..n](1≤i≤n-1)，该趟排序则是从当前无序区中选出关键字最小的记录R[k]，
     * 将它与无序区的第1个记录R[i]交换，使R[1..i]和R[i+1..n]分别变为新的有序区和新的无序区。因为每趟排序均使有序区中增加了一个记录，
     * 且有序区中的记录关键字均不大于无序区中记录的关键字，即第i趟排序之后R[1..i].keys≤R[i+1..n].keys，
     * 所以进行n-1趟排序之后有R[1..n-1].keys≤R[n].key，也就是说，经过n-1趟排序之后，整个文件R[1..n]递增有序。
     *
     * 时间复杂度：O(n^2) 空间复杂度：O(1)  稳定性：不稳定
     * @param arrays
     */
    private static void sort5(int[] arrays){
        int i, j, temp, minIndex;
        for(i = 0; i < arrays.length - 1; i++){// 冒泡排序、直接插入排序、直接选择排序 进行 n - 1 次循环
            minIndex = i;//初始化将第一个值设置成最小值的下标
            for(j = i + 1; j < arrays.length; j++){// 从i + 1中选取最小值
                if(arrays[minIndex] > arrays[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                temp = arrays[minIndex];
                arrays[minIndex] = arrays[i];
                arrays[i] = temp;
            }
        }
    }

    /**
     * 6.堆排序
     * 直接选择排序中，为了从R[1..n]中选出关键字最小的记录，必须进行n-1次比较，然后在R[2..n]中选出关键字最小的记录，又需要做n-2次比较。
     * 事实上，后面这n-2次比较中，有许多比较可能在前面的n-1次比较中已经做过，但由于前一趟排序时未保留这些比较的结果，所以后一趟排序时又重复执行了这些比较操作。
     * 堆排序可以克服这一缺点。堆排序( Heap Sort)是一树形选择排序，特点：在排序过程中，将R[1..n]看成是一棵完全二叉树的顺序存储结构，
     * 利用完全二叉树中双亲结点和孩子结点之间的内在关系，在当前无序区中选择关键字最大(或最小)的记录。
     *
     * 基本思想是：
     * 1、将带排序的序列构造成一个大顶堆，根据大顶堆的性质，当前堆的根节点（堆顶）就是序列中最大的元素；
     * 2、将堆顶元素和最后一个元素交换，然后将剩下的节点重新构造成一个大顶堆；
     * 3、重复步骤2，如此反复，从第一次构建大顶堆开始，每一次构建，我们都能获得一个序列的最大值，然后把它放到大顶堆的尾部。最后，就得到一个有序的序列了
     *
     * 时间复杂度：O(nlogn)   空间复杂度：O(1)  稳定性：不稳定
     * @param arrays
     */
    private static void sort6(int[] arrays){
        if(arrays == null || arrays.length == 0){
            return;
        }
        int len = arrays.length;
        //构建最大堆, 这里其实就是把待排序序列，变成一个大顶堆结构的数组
        buildMaxHeap(arrays, len);
        // 交换堆顶和当前末尾的节点，重置大顶堆
        for(int i = len - 1; i > 0; i--){
            swap (arrays, 0, i);// 堆顶元素与最后一个值互换
            len--;
            heapify(arrays, 0, len);
        }
    }

    /**
     * 构建最大堆
     */
    private static void buildMaxHeap(int[] arrays, int len){
        //从第一个非叶子节点向前遍历，调整节点的位置，使之成为最大堆
        for(int i = (int)Math.floor(len / 2) - 1; i >= 0; i--){
            heapify(arrays, i, len);
        }
    }

    /**
     * 堆化
     * @param arrays
     * @param cur
     * @param len
     */
    private static void heapify(int[] arrays, int cur, int len){
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;
        int maxIndex = cur;//初始化当前下标为最大值的下标
        if(left < len && arrays[left] > arrays[maxIndex]){
            maxIndex = left;
        }
        if(right < len && arrays[right] > arrays[maxIndex]){
            maxIndex = right;
        }
        if(maxIndex != cur){
            swap (arrays, maxIndex, cur);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整
            heapify(arrays, maxIndex, len);
        }
    }


    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *  7.归并排序
     *  归并排序的实现由两种方法：自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；自下而上的迭代;
     *  算法步骤：
     *  1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     *  2、设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     *  3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     *  4、重复步骤 3 直到某一指针达到序列尾；
     *  5、将另一序列剩下的所有元素直接复制到合并序列尾。
     *  时间复杂度：O(nlogn)  空间复杂度：O(n)  稳定性：稳定
     * @param arrays
     */
    private static int[] sort7(int[] arrays){
        return sort(arrays, 0, arrays.length - 1);// 归并排序需要将结果返回
    }

    /**
     * 不断的拆分
     * @param arrays
     * @param start
     * @param end
     * @return
     */
    private static int[] sort(int[] arrays, int start, int end){
        if(start == end){
            return Arrays.copyOfRange(arrays, start, end + 1);// 该函数含头不含尾
        }
        int mid = (end - start) / 2 + start;
        int[] left = sort(arrays, start, mid);
        int[] right = sort(arrays, mid + 1, end);
        return merge(left, right);
    }

    /**
     * 归并
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right){
        int[] merge = new int[left.length + right.length];
        int lIndex = 0;
        int rIndex = 0;
        int cur = 0;
        while(lIndex < left.length && rIndex < right.length){
            if(left[lIndex] > right[rIndex]){
                merge[cur++] = right[rIndex++];
            }else if(left[lIndex] < right[rIndex]){
                merge[cur++] = left[lIndex++];
            }else{
                merge[cur++] = left[lIndex++];
                merge[cur++] = right[rIndex++];
            }
        }
        if(lIndex < left.length){
            while (lIndex < left.length){
                merge[cur++] = left[lIndex++];
            }
        }
        if(rIndex < right.length){
            while (rIndex < right.length){
                merge[cur++] = right[rIndex++];
            }
        }
        return merge;
    }

    /**
     * 8.桶排序
     * 桶排序（箱排序 (Bucket sort)），工作的原理是将数组分到有限数量的桶子里。
     * 每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序。
     *
     * 算法步骤：
     * 假设有一组长度为N的待排关键字序列K[1....n]。
     * 1、首先将这个序列划分成M个的子区间(桶)。
     * 2、然后基于某种映射函数 ，将待排序列的关键字k映射到第i个桶中(即桶数组B的下标 i) ，那么该关键字k就作为B[i]中的元素(每个桶B[i]都是一组大小为N/M的序列)。
     * 3、对每个桶B[i]中的所有元素进行比较排序(可以使用快排)。
     * 4、然后依次枚举输出B[0]....B[M]中的全部内容即是一个有序序列
     *
     * 前面所讨论的排序算法均是基于关键字之间的比较来实现的，而理论上已证明：
     * 对于这样的排序，无论用何方法都至少要进行[lgn]次关键字的比较。由 Stirling公式可知lgn≈nlgn-1.44n+0(lgn)，所以基于关键字比较的排序时间下界是O(nlgn)。
     * 但是，若不通过比较关键字来排序，则可能突破此下界。
     * 分配排序正是如此，排序过程无须比较关键字，而是通过“分配”和“收集”过程来实现排序，它们的时间复杂度可达到线性阶：O(n)
     *
     * 时间复杂度：O(n+k) 空间复杂度：O(n+k)    稳定性：稳定
     * @param arrays
     */
    private static int[] sort8(int[] arrays){
        return bucketsort(arrays, 5);
    }

    private static int[] bucketsort(int[] arrays, int bucketSize){
        // 9, 3, 8, 7, 5, 1, 2, 10, 9
        if(arrays == null || arrays.length == 0){
            return arrays;
        }
        // 1.根据最大值、最小值计算桶的长度
        int minVal = arrays[0];
        int maxVal = arrays[0];
        for(int arr : arrays){
            if(arr < minVal){
                minVal = arr;
            }else if(arr > maxVal){
                maxVal = arr;
            }
        }
        int bucketCount = (int)Math.floor((maxVal - minVal) / bucketSize) + 1;

        // 初始化桶
        int[][] buckets = new int[bucketCount][0];

        for (int arr : arrays){
            // 2.计算每个元素桶里面的下标
            int bucketIndex = (int)Math.floor((arr - minVal) / bucketSize);
            buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], arr);
        }

        // 3.每个桶进行排序，并合并成新的数组
        int sortIndex = 0;
        for(int[] bucket : buckets){
            if(bucket == null || bucket.length == 0){// 桶为空
                continue;
            }
            sort6(bucket);// 使用堆排序对每个桶进行排序
            for(int arr : bucket){
                arrays[sortIndex++] = arr;
            }
        }
        return arrays;
    }

    /**
     * 数组扩容，并记录对应的值
     * @param arrays
     * @param arr
     */
    private static int[] arrayAppend(int[] arrays, int arr){
        arrays = Arrays.copyOf(arrays, arrays.length + 1);
        arrays[arrays.length - 1] = arr;
        return arrays;
    }

    /**
     * 9.基数排序
     * 基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：
     * 将整数按位数切割成不同的数字，然后按每个位数分别比较。
     * 具体做法：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
     * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     *
     * 算法步骤
     * 1、将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 2、从最低位开始，依次进行一次排序。
     * 3、这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     *
     * 时间复杂度：O(n*k) 空间复杂度：O(n+k)    稳定性：稳定
     * @param sourceArray
     * @return
     */
    public static int[] sort9(int[] sourceArray){
        int maxDigit = getMaxDigit(sourceArray);// 获取最大值的位数
        return radixSort(sourceArray, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static int[] radixSort(int[] arrays, int maxDigit) {
        // 用于取出某个位数上的值 arr % mod / dev
        int mod = 10;// 用于取余数
        int dev = 1;// 用于取整数
        for(int i = 0; i < maxDigit; i++, mod *= 10, dev *= 10){
            int[][] buckets = new int[mod * 2][0];// *2 用于存储负数
            for(int arr : arrays){
                int bucketIndex = (arr % mod) / dev + mod;
                buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], arr);
            }
            int bucketIndex = 0;
            for(int[] bucket : buckets){
                if(bucket == null || bucket.length == 0){
                    continue;
                }
                for(int arr : bucket){
                    arrays[bucketIndex++] =  arr;
                }
            }
        }
        return arrays;
    }


}