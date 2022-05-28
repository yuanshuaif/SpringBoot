package com.lsj.springboot.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *  1491. 去掉最低工资和最高工资后的工资平均值
 *
 *  剑指 Offer 42. 连续子数组的最大和(同53. 最大子序和)
 *
 *  922. 按奇偶排序数组 II
 *
 *  252. 会议室
 *
 *  976. 三角形的最大周长
 *
 *  56. 合并区间
 *
 *  57. 插入区间
 *
 *  1288. 删除被覆盖区间
 *
 *  面试题 17.14. 最小K个数
 *
 *  75. 颜色分类
 *
 *  1086. 前五科的均分
 *
 *  1502. 判断能否形成等差数列
 *
 *  1122. 数组的相对排序
 *
 *  1561. 你可以获得的最大硬币数目
 *
 *  179. 最大数
 *
 *  280. 摆动排序
 *
 */
public class Sort {
    /**
     * 1491. 去掉最低工资和最高工资后的工资平均值
     * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
     * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
     * 输入：salary = [4000,3000,1000,2000]    输出：2500.00000
     * 解释：最低工资和最高工资分别是 1000 和 4000 。去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        double nums = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : salary){
            nums += num;
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return (nums - max - min) / (salary.length - 2);
    }

    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]   输出: 6   解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 动态规划时间复杂度O(n)  分治算法时间复杂度O(nlogn)
     *
     * 思路：连续子序列的最大和主要由这三部分子区间里元素的最大和得到：
     *      第 1 部分：子区间 [left, mid]；
     *      第 2 部分：子区间 [mid + 1, right]；
     *      第 3 部分：包含子区间 [mid , mid + 1] 的子区间，即 nums[mid] 与 nums[mid + 1] 一定会被选取。
     *      对这三个部分求最大值即可。
     *      说明：考虑第 3 部分跨越两个区间的连续子数组的时候，由于 nums[mid] 与 nums[mid + 1] 一定会被选取，可以从中间向两边扩散，扩散到底 选出最大值。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //分治算法 分而治之，归并子集
        return maxSubArrayDivideWithBroder(nums, 0, nums.length - 1);
    }

    public int maxSubArrayDivideWithBroder(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int center = (start + end) / 2;
        int left = maxSubArrayDivideWithBroder(nums, start, center);
        int right = maxSubArrayDivideWithBroder(nums, center + 1, end);

        int ansSubLeft = nums[center];
        int sumSubLeft = 0;
        for(int i = center; i >= start; i--){
            sumSubLeft += nums[i];
            ansSubLeft = Math.max(ansSubLeft, sumSubLeft);
        }
        int ansSubRight = nums[center + 1];
        int sumSubRight = 0;
        for(int i = center + 1; i <= end; i++){
            sumSubRight += nums[i];
            ansSubRight = Math.max(sumSubRight, ansSubRight);
        }
        int sumSub = ansSubLeft + ansSubRight;
        return Math.max(sumSub, Math.max(left, right));
    }

    /**
     * 922. 按奇偶排序数组 II
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * 你可以返回任何满足上述条件的数组作为答案
     * 输入：[4,2,5,7]     输出：[4,5,2,7]    解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     * 2 <= A.length <= 20000       A.length % 2 == 0       0 <= A[i] <= 1000
     *
     * 双指针
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        int temp = 0;
        int even = 0;
        int odd = 1;
        for(; even < A.length; even = even + 2){
            if(A[even] % 2 == 1){// 偶数位如果是奇数
                for(; odd < A.length; odd = odd + 2){
                    if(A[odd] % 2 != 1){// 奇数位如果是偶数
                        temp = A[odd];
                        A[odd] = A[even];
                        A[even] = temp;
                        break;
                    }
                }
            }
        }
        return A;
        /*int temp = 0;
        int even = 0;// 偶数
        int odd = 1;// 奇数
        for(; even < A.length && odd < A.length; ){
            if(A[even] % 2 == 1 && A[odd] % 2 != 1){// 偶数位如果是奇数 && 奇数位如果是偶数
                temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
                even = even + 2;
                odd = odd + 2;
            }else if(A[even] % 2 == 1){// 偶数位如果是奇数
                odd = odd + 2;
            }else if(A[odd] % 2 != 1){// 奇数位如果是偶数
                even = even + 2;
            }else {
                even = even + 2;
                odd = odd + 2;
            }
        }
        return A;*/
    }

    /**
     * 976. 三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * 输入：[2,1,2]   输出：5                输入：[1,2,1]    输出：0
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        //形成三角形的前提：2边之和大于第3边
        Arrays.sort(A);
        for(int i = A.length -1; i >= 2; i--){
            if(A[i] < A[i - 1] + A[i - 2]){
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    /**
     * 区间算法的相关题目
     */
    static class Interval{


        /**
         * 252. 会议室
         * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，请你判断一个人是否能够参加这里面的全部会议。
         * 输入: [[0,30],[5,10],[15,20]]   输出: false
         * 输入: [[7,10],[2,4]]   输出: true
         * @param intervals
         * @return
         */
        public boolean canAttendMeetings(int[][] intervals) {
            Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);// 对第一列进行排序
            for(int i = 0; i < intervals.length - 1; i++){
                if(intervals[i][1] > intervals[i + 1][0]){
                    return false;
                }
            }
            return true;
        }

        /**
         * 56. 合并区间
         * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]     输出: [[1,6],[8,10],[15,18]]
         * 输入: intervals = [[1,4],[4,5]]    输出: [[1,5]]
         * 输入: intervals = [[1,4],[2,3],[4,5],[6,7]]    输出: [[1,5]],[6,7]]
         *
         *  （区间问题：重叠区间、合并区间、插入区间）（相交一部分；全部相交；不相交）
         *  核心算法：1.先根据区间的起始位置排序；2.再进行 n -1n−1 次 两两合并。
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            if(intervals == null && intervals.length < 2){
                return intervals;
            }
            // 1.对二维数组第一列进行排序
            Arrays.sort(intervals, (a1, a2) -> a1[0] -a2[0]);
            int[][] res = new int[intervals.length][2];
            int index = -1;
            for(int[] interval : intervals){
                if(index == -1 || interval[0] > res[index][1]){// 2.1返回列表为空或者2者不相交时，直接放入返回数组
                    res[++index] = interval;
                }else{// 2.2部分相交或者全部相交
                    res[index][1] = Math.max(res[index][1], interval[1]);
                }
            }
            return Arrays.copyOf(res, index + 1);
        }

        /**
         * 57. 插入区间
         * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
         * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
         * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]    输出：[[1,5],[6,9]]
         *
         * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]       输出：[[1,2],[3,10],[12,16]]
         * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
         * https://mp.weixin.qq.com/s/ioUlNa4ZToCrun3qb4y4Ow           区间的相关问题
         *
         * 本题中的区间已经按照起始端点升序排列，因此我们直接遍历区间列表，寻找新区间的插入位置即可。具体步骤如下：
         * 1.首先将新区间左边且相离的区间加入结果集（遍历时，如果当前区间的结束位置小于新区间的开始位置，说明当前区间在新区间的左边且相离）；
         * 2.接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，将最终合并后的新区间加入结果集；
         * 3.最后将新区间右边且相离的区间加入结果集。
         *
         * 滑动窗口思想
         * @param intervals
         * @param newInterval
         * @return
         */
        public int[][] insert(int[][] intervals, int[] newInterval) {
       /* if(intervals == null){
            intervals = new int[][]{newInterval};
            return intervals;
        }
        intervals = Arrays.copyOf(intervals, intervals.length + 1);
        intervals[intervals.length - 1] = newInterval;

        // 1.对二维数组第一列进行排序
        Arrays.sort(intervals, (a1, a2) -> a1[0] -a2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for(int[] interval : intervals){
            if(index == -1 || interval[0] > res[index][1]){// 2.1返回列表为空或者2者不相交时，直接放入返回数组
                res[++index] = interval;
            }else{// 2.2部分相交或者全部相交
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);*/
            if(intervals == null){
                intervals = new int[][]{newInterval};
                return intervals;
            }
            int length = intervals.length;
            int[][] res = new int[length + 1][2];
            int idx = 0;
            int i = 0;
            // 1.将新区间左边且相离的区间加入结果集
            while(i < length && intervals[i][1] < newInterval[0]){
                res[idx++] = intervals[i++];
            }
            // 2.接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，将最终合并后的新区间加入结果集；
            while(i < length && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            res[idx++] = newInterval;
            // 3.最后将新区间右边且相离的区间加入结果集。
            while(i < length){
                res[idx++] = intervals[i++];
            }
            return Arrays.copyOf(res, idx);
        }

        /**
         * 1288. 删除被覆盖区间
         * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
         * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
         * 输入：intervals = [[1,4],[3,6],[2,8]]   输出：2    解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
         * 1 <= intervals.length <= 1000    0 <= intervals[i][0] < intervals[i][1] <= 10^5  对于所有的 i != j：intervals[i] != intervals[j]
         *
         * 1.先对原始数组进行排序，左边界升序，右边界降序，这样遍历比较时只需要考虑右边界即可。以此保证左边界相同时，右边的都是可以删除的。
         * 2.用一个符号max记录当前最大的有边界，当左边界不同时，当前右边界的若小于前一个，则可删除，否则就比较当前右边界和上一个哪一个较大，替换max。
         * @param intervals
         * @return
         */
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);// 开始位置升序，结束位置降序
            int length = intervals.length;
            int count = length;
            int max = intervals[0][1];
            for(int i = 1; i < length; i++){
                if(intervals[i][1] <= max){
                    count--;
                }else {
                    max = intervals[i][1];
                }
            }
            return count;
        }

        /**
         * 228. 汇总区间
         * 给定一个无重复元素的有序整数数组 nums 。
         * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
         * 列表中的每个区间范围 [a,b] 应该按如下格式输出："a->b" ，如果 a != b          "a" ，如果 a == b
         *
         * 输入：nums = [0,1,2,4,5,7]  输出：["0->2","4->5","7"]
         * 解释：区间范围是：[0,2] --> "0->2"     [4,5] --> "4->5"    [7,7] --> "7"
         *
         * 输入：nums = [0,2,3,4,6,8,9]    输出：["0","2->4","6","8->9"]
         * 解释：区间范围是：[0,0] --> "0"   [2,4] --> "2->4"    [6,6] --> "6"   [8,9] --> "8->9"
         *
         * 输入：nums = []     输出：[]
         * 输入：nums = [-1]   输出：["-1"]
         * 输入：nums = [0]    输出：["0"]
         *
         * 0 <= nums.length <= 20       -231 <= nums[i] <= 231 - 1      nums 中的所有值都 互不相同
         *
         * 双指针
         * @param nums
         * @return
         */
        public static List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            int start = 0;
            for(int cur = 0; cur < nums.length; cur++){
                if(cur + 1 == nums.length || nums[cur] + 1 != nums[cur + 1]){// 结束了或者不连续则输出
                    result.add(nums[start] + (cur == start ? "" : "->" + nums[cur]));
                    start = cur + 1;
                }
            }
            return result;
        }

        public static void main(String[] args){
            System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
        }
    }

    /**
     * 面试题 17.14. 最小K个数
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     * 示例：输入： arr = [1,3,5,7,2,4,6,8], k = 4    输出： [1,2,3,4]
     * 快排思想
     * @param arr
     * @param k
     * @return
     */
    /*public int[] smallestK(int[] arr, int k) {
        sort(arr, 0, arr.length - 1);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = arr[i];
        }
        return ans;
    }
    public void sort(int[] arr, int left, int right){
        if(arr.length == 0){
            return;
        }
        int fLeft = left;
        int fRight = right;
        int x = arr[left];
        while(fLeft < fRight){
            while(fLeft < fRight && arr[fRight] >= x){
                fRight--;
            }
            if(fLeft < fRight){
                arr[fLeft++] = arr[fRight];
            }
            while(fLeft < fRight && arr[fLeft] < x){
                fLeft++;
            }
            if(fLeft < fRight){
                arr[fRight--] = arr[fLeft];
            }
        }
        arr[fLeft] = x;// fLeft == fRight
        if(left < fLeft){
            sort(arr, left, fLeft - 1);
        }
        if(right > fRight){
            sort(arr, fRight + 1, right);
        }
    }*/

    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 输入: [2,0,2,1,1,0]    输出: [0,0,1,1,2,2]
     * 三指针
     * @param nums
     */
    public void sortColors(int[] nums) {
        // 三色问题
        int start = 0;
        int end = nums.length - 1;
        int cur = 0;
        while(cur <= end){
            if(nums[cur] == 0){
                swap(nums, start, cur);
                cur++;
                start++;
            }else if(nums[cur] == 2){
                swap(nums, cur, end);
                end--;
            }else{
                cur++;
            }
        }
    }


    /**
     * 1086. 前五科的均分
     * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
     * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
     * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
     * 输出：[[1,87],[2,88]]
     * 解释：id = 1 的学生平均分为 87。id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
     * @param items
     * @return
     */
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);// id升序，成绩降序
        int num = items[items.length - 1][0];// 最后一个学生的id
        int[][] result = new int[num][2];
        for(int i = 0; i < items.length; i++){
            if(i == 0 || items[i][0] != items[i - 1][0]){// 第一个学生或者是下一个学生
                int id = items[i][0];
                result[id - 1][0] = id;
                int sum = 0;
                for(int j = i; j < i + 5; j++){
                    sum += items[j][1];
                }
                result[id - 1][1] = sum / 5;
                i = i + 4;
            }
        }
        return result;
    }

    /**
     * 1502. 判断能否形成等差数列
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     * 输入：arr = [3,5,1]     输出：true     解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
     * 输入：arr = [1,2,4]     输出：false    解释：无法通过重新排序得到等差数列。
     * 提示：2 <= arr.length <= 1000           -10^6 <= arr[i] <= 10^6
     * @param arr
     * @return
     */
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i = 2; i < arr.length; i++){
            if(arr[i] - arr[i - 1] != arr[1] - arr[0]){
                return false;
            }
        }
        return true;
    }

    /**
     * 1122. 数组的相对排序
     * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同    arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *
     * 1.arr1.length, arr2.length <= 1000       2.0 <= arr1[i], arr2[i] <= 1000
     * 3.arr2 中的元素 arr2[i] 各不相同           4.arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int cur = 0;
        // 对在arr2里出现的元素进行排序
        for(int i = 0; i < arr2.length; i++){
            for(int j = cur; j < arr1.length; j++){
                if(arr1[j] == arr2[i]){
                    int temp = arr1[j];
                    arr1[j] = arr1[cur];
                    arr1[cur++] = temp;
                }
            }
        }
        // 对没在arr2里出现的元素进行排序
        int[] temp = Arrays.copyOfRange(arr1, cur, arr1.length);
        Arrays.sort(temp);
        for(int i = 0; i < temp.length; i++){
            arr1[cur++] = temp[i];
        }
        return arr1;
    }

    /**
     * 1561. 你可以获得的最大硬币数目
     * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
     * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。Alice 将会取走硬币数量最多的那一堆。你将会取走硬币数量第二多的那一堆。
     *  Bob 将会取走最后一堆。重复这个过程，直到没有更多硬币。
     *  给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
     * 输入：piles = [2,4,1,2,7,8] 输出：9
     * 解释：选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 7 枚硬币的那堆，Bob 取走最后一堆。
     *      选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 2 枚硬币的那堆，Bob 取走最后一堆。
     *      你可以获得的最大硬币数目：7 + 2 = 9.
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        for(int i = 0; i < piles.length / 3; i++){
            ans += piles[piles.length - 2 * (i + 1)];// 本人每次都取倒数第二个，才能保证规则内，利益最大化
        }
        return ans;
    }

    /**
     * 179. 最大数
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * 输入: [10,2]      输出: 210          输入: [3,30,34,5,9]     输出: 9534330
     * [0,00] 0]
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        // 使用temp的原因是, Arrays.sort(),使用封装类
        Integer[] temp = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                String s1 = a + "" + b;// 102
                String s2 = b + "" + a;// 210
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int num : temp){
            sb.append(num);
        }
        //[0,00]
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }

    /**
     * 280. 摆动排序
     * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
     * 输入: nums = [3,5,2,1,6,4] 输出: 一个可能的解答是 [3,5,1,6,2,4]
     * 1,2,3,4,5
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        // 偶数位的值 > 下一个奇数位的值 交换2个值
        // 奇数位的值 < 下一个偶数位的值 交换2个值
        for(int i = 0; i < nums.length - 1; i++){
            if(((i & 1) == 0 && nums[i] > nums[i + 1]) || ((i & 1) == 1 && nums[i] < nums[i + 1])){
                swap(nums, i, i + 1);
            }
        }
    }


    public static void main(String[] args){
//        System.out.println(sortArrayByParityII(new int[]{4,2,5,6,9,7}));
//        System.out.println(canMakeArithmeticProgression(new int[]{1,2,4}));
//        System.out.println(relativeSortArray(new int[]{2,3,1,3,2,4,6,19,9,2,8,7}, new int[]{2,1,4,3,9,6}));
        System.out.println(smallestK(new int[]{1,3,5,7,2,4,6,8}, 4));
    }

    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static int[] smallestK(int[] arrays, int k) {
        int len = arrays.length;
        //构建最小堆, 这里其实就是把待排序序列，变成一个小顶堆结构的数组
        buildMinHeap(arrays, len);
        // 交换堆顶和当前末尾的节点，重置小顶堆
        int[] ans = new int[k];
        int j = 0;
        for(int i = len - 1; i >= len - k; i--){
            swap (arrays, 0, i);// 堆顶元素与最后一个值互换
            ans[j++] = arrays[i];
            len--;
            heapify(arrays, 0, len);
        }
        return ans;
    }
    /**
     * 构建最小堆
     */
    private static void buildMinHeap(int[] arrays, int len){
        //从第一个非叶子节点向前遍历，调整节点的位置，使之成为最小堆
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
        int minIndex = cur;//初始化当前下标为最小值的下标
        if(left < len && arrays[left] < arrays[minIndex]){
            minIndex = left;
        }
        if(right < len && arrays[right] < arrays[minIndex]){
            minIndex = right;
        }
        if(minIndex != cur){
            swap (arrays, minIndex, cur);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整
            heapify(arrays, minIndex, len);
        }
    }
}
