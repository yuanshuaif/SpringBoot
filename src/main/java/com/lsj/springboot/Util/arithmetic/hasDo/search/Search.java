package com.lsj.springboot.Util.arithmetic.hasDo.search;

/**
 * https://mp.weixin.qq.com/s?__biz=MzIwNDgxNDM0MQ==&mid=2247488478&idx=1&sn=c0dcff11a8a7f097b21d6da448e80bcb&chksm=973b32b4a04cbba2b1c2ba59120d38e13cabf3bbe3529ec92100831315d0f7ff91347df014a7&scene=21#wechat_redirect
 * 线性表的查找
 *
 * https://mp.weixin.qq.com/s?__biz=MzIwNDgxNDM0MQ==&mid=2247488518&idx=1&sn=2ccff20c9efa7f247be4fa1412cbf831&chksm=973b356ca04cbc7a7c94ee7a6ecd27364d2e6ecf52705c4fc45f18a3758df238845c76f3f8c6&scene=21#wechat_redirect
 * 树的查找
 */

public class Search {
    /**
     * 1.顺序查找
     * @param arry
     * @param des
     * @return
     */
    public static int ordersearch(int[] arry, int des) {
        for (int i = 0; i <= arry.length - 1; i++) {
            if (des == arry[i])
                return i;
        }
        return -1;
    }

    /**
     * 2.二分查找
     * 分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列
     *
     * 首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功；否则利用中间位置记录将表分成前、
     * 后两个子表，如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，否则进一步查找后一子表。重复以上过程，直到找到满足条件的记录
     * ，使查找成功，或直到子表不存在为止，此时查找不成功。
     *
     * 二分查找需要注意计算中间值的时候下标越界的问题
     * @param srcArray
     * @param des
     * @return
     */
    public static int binarySearch(Integer[] srcArray, int des) {
        int start = 0;
        int end = srcArray.length - 1;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            if(srcArray[mid] == des){
                return des;
            }else if(srcArray[mid] < des){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 3.分块查找
     * 分块查找是折半查找和顺序查找的一种改进方法，分块查找由于只要求索引表是有序的，对块内节点没有排序要求，因此特别适合于节点动态变化的情况。
     *
     * 分块查找要求把一个大的线性表分解成若干块，每块中的节点可以任意存放，但块与块之间必须排序。
     * 假设是按关键码值非递减的，那么这种块与块之间必须满足已排序要求，实际上就是对于任意的i，第i块中的所有节点的关键码值都必须小于第i+1块中的所有节点的关键码值。
     * 此外，还要建立一个索引表，把每块中的最大关键码值作为索引表的关键码值，按块的顺序存放到一个辅助数组中，显然这个辅助数组是按关键码值费递减排序的。
     * 查找时，首先在索引表中进行查找，确定要找的节点所在的块。由于索引表是排序的，因此，对索引表的查找可以采用顺序查找或折半查找；
     * 然后，在相应的块中采用顺序查找，即可找到对应的节点。
     * @param index
     * @param st2
     * @param keytype
     * @param m
     * @return
     */
    //index代表索引数组，st2代表待查找数组，keytype代表要查找的元素，m代表每块大小
    public static int blocksearch(int[] index, int[] st2, int keytype, int m){
        int i = shunxusearch(index, keytype);    //shunxunsearch函数返回值为带查找元素在第几块
        if(i >= 0){
            int j = m * i;   //j为第i块的第一个元素下标
            int curlen = (i + 1) * m;
            for(;j < curlen; j++){
                if(st2[j] == keytype)
                    return st2[j];
            }
        }
        return -1;

    }
    public static int shunxusearch(int[]index,int keytype) {
        if (index[0] > keytype) {// 小于最小块
            return 0;
        }else if(index[index.length - 1] < keytype){// 大于最大块
            return -1;
        }
        int i = 1;
        while (!(index[i - 1] < keytype && index[i] > keytype) && i < index.length)
            i++;
        return i;
    }


    public static void main(String[] args){
//        Integer[] integers = new Integer[]{1, 3, 4, 6, 8, 9};
//        System.out.println(binarySearch(integers, 6));

        System.out.println(blocksearch(new int[]{3, 6, 9}, new int[]{3, 1, 6, 4, 8, 9}, 8, 2));
    }

    /**
      * 树的查找
     */
    class TreeSearch {

        public class BiTreeNode {
            int value;
            BiTreeNode left;
            BiTreeNode right;
        }


        /**
         * 1.二叉排序树（二叉搜索树）的查找
         * 二叉排序树( Binary Sort Tree称二叉查找(搜索) Binary Search Tree，
         * 定义：二叉排序树或者是空树，或者是满足如下性质的二叉树：
         * ①若它的左子树非空，则左子树上所有结点的值均小于根结点的值；
         * ②若它的右子树非空，则右子树上所有结点的值均大于根结点的值；
         * ③左、右子树本身又各是一棵二叉排序树。
         */
        //二叉排序树，二叉查找树，二查搜索树，是一颗具有如下特点的树，树的左边都比它小，树的右边都比它大。
        public BiTreeNode BinaryBiSearch(BiTreeNode pHead, int b) {
            if (pHead == null)
                return null;
            if (pHead.value == b) {
                return pHead;
            } else if (pHead.value > b) {
                return BinaryBiSearch(pHead.left, b);
            } else if (pHead.value < b) {
                return BinaryBiSearch(pHead.right, b);
            }
            return null;
        }
    }

}
