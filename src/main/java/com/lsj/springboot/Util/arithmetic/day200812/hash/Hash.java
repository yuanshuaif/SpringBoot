package com.lsj.springboot.Util.arithmetic.day200812.hash;

import com.lsj.springboot.Util.arithmetic.day200818.Maths;

import java.util.*;

/**
 * Created by 10326 on 2020/8/17.
 *
 * 题目350：两个数组的交集 II
 * hash表
 *
 * 题目532:数组中的K-diff数对
 * hash表
 *
 * 题目242:有效的字母异位词
 *
 * 题目136:只出现一次的数字
 * hash表  位运算-异或
 *
 * 题目217：存在重复元素
 * set也是hash表的一种
 *
 * 题目204:计数质数
 *
 * 题目219:存在重复元素 II
 *
 * 题目389:找不同（类似于136）
 *
 * 题目594：最长和谐子序列
 *
 * 题目624：数组列表中的最大距离
 *
 * 题目645：错误的集合
 * hash表、异或
 *
 * 题目1002：查找常用字符
 *
 * 题目387：字符串中的第一个唯一字符
 *
 * 题目202：快乐数
 *
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * 题目1496：判断路径是否相交
 *
 */
public class Hash {

    /**
     * 350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]  输出：[2,2]
     * 时间复杂度：O(m+n)         空间复杂度：O(\min(m,n))
     * 说明：输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。我们可以不考虑输出结果的顺序。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // hash表的方式
        if(nums1.length > nums2.length){
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for(Integer integer : nums1){
            Integer count = hash.getOrDefault(integer, 0) + 1;
            hash.put(integer, count);
        }
        int[] ans = new int[nums2.length];
        int k = 0;
        for(int i = 0; i < nums2.length; i++){
            Integer count = hash.getOrDefault(nums2[i], 0);
            if(count > 0){
                ans[k++] = nums2[i];
                hash.put(nums2[i], --count);
            }
        }
        return Arrays.copyOf(ans, k);
    }

    /**
     * 532. 数组中的K-diff数对
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j),
     * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     * 输入: [3, 1, 4, 1, 5], k = 2   输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。尽管数组中有两个1，但我们只应返回不同的数对的数量
     * 输入:[1, 2, 3, 4, 5], k = 1    输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 输入: [1, 3, 1, 5, 4], k = 0   输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Map<Integer, Integer> map =  new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(k == 0 && value > 1){
                ans++;
            }else if(k > 0 && map.containsKey(key - k)){
                ans ++;
            }
        }
        return ans;
    }

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 输入: s = "anagram", t = "nagaram" 输出: true
     * 输入: s = "rat", t = "car" 输出: false
     * 你可以假设字符串只包含小写字母。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        //hash表
        if(s.length() != t.length()){
            return false;
        }
        int[] ans = new int[26];
        for(int i = 0; i < s.length(); i++){
            ans[s.charAt(i) - 'a']++;
            ans[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < ans.length; i++){
            if(ans[i] != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 136. 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : nums){
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        int target = 0;
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() == 1){
//                target = entry.getKey();
//            }
//        }
//        return target;

        // 位运算~异或
        //1.a^0=a;
        //2.a^a=0;
        //3.满足交换律 a^b^a = a^a^b = 0^b = b;
        int target = 0;
        for(int num :nums){
            target ^= num;
        }
        return target;

    }

    /**
     * 217. 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * 输入: [1,2,3,1]    输出: true
     * 输入: [1,2,3,4]    输出: false
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

//        Map<Integer, Integer> hash = new HashMap<>();
//        for(int num : nums){
//            hash.put(num, hash.getOrDefault(num, 0) + 1);
//        }
//        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
//            if(entry.getValue() > 1){
//                return true;
//            }
//        }
//        return false;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;

    }


    /**
     * 204. 计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     * 输入: 10   输出: 4   解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     * 核心算法：1.2是质数；2.只有奇数可能是质数，这个奇数能否被小于等于平方根的奇数除尽
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int count = 0;
        if (n > 2) {// n>2，一定会有2这个质数
            count++;
        }
        for(int i = 3; i < n; i = i + 2){// 偶数不是质数，判断奇数是不是质数
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int src) {
        double sqrt = Math.sqrt(src);
        for (int i = 3; i <= sqrt; i += 2) {
            if (src % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 219. 存在重复元素 II
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     * 输入: nums = [1,2,3,1], k = 3  输出: true ;  输入: nums = [1,0,1,1], k = 1  输出: true;  输入: nums = [1,2,3,1,2,3], k = 2  输出: false
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.add(nums[i])){// 1.添加成功
                if(set.size() > k){// 3.保持队列长度最大为k
                    set.remove(nums[i - k]);// 移除最前面的数字
                }
            }else {// 2.添加失败，距离范围内存在重复元素
                return true;
            }
        }
        return false;
    }

    /**
     * 389. 找不同（类似于136）
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 请找出在 t 中被添加的字母。
     * 输入：s = "abcd" t = "abcde"    输出：e
     * 解释：'e' 是那个被添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
       /* Map<String, Integer> hash = new HashMap<>();
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for(int i = 0; i < charS.length; i++){
            hash.put(charS[i] + "", hash.getOrDefault(charS[i] + "", 0) + 1);
        }
        char diff = '0';
        for(int i = 0; i < charT.length; i++){
            Integer value = hash.get(charT[i] + "");
            if(value != null && value != 0){
                hash.put(charT[i] + "", value - 1);
            }else{
                diff = charT[i];
            }
        }
        return diff;*/
       // 相同字符异或等于0
       if(s.equals("")){
           return t.charAt(0);
       }
        char diff = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            diff ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++){
            diff ^= t.charAt(i);
        }
        return diff;
    }

    /**
     * 594. 最长和谐子序列
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     * 输入: [1,3,2,2,5,2,3,7]    输出: 5   原因: 最长的和谐数组是：[3,2,2,2,3].
     * @param nums
     * @return
     */
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(hash.containsKey(key + 1)){
                value += hash.get(key + 1);
                ans = Math.max(ans, value);
            }
        }
        return ans;

    }

    /**
     * 624. 数组列表中的最大距离
     * 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
     * 输入： [[1,2,3],[4,5],[1,2,3]]      输出： 4
     * 解释：一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
     *
     * 1.每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。2.所有 m 个数组中的数字总数目在范围 [2, 10000] 内。3.m 个数组中所有整数的范围在 [-10000, 10000] 内。
     * 核心算法：1。找出不为空的行i内的最大值、最小值作为历史最小行，历史最大行；2.从i+1开始不为空的行，计算最大值、历史最小行，历史最大行
     * @param arrays
     * @return
     */
    public static int maxDistance(List<List<Integer>> arrays) {
        // [[-8,-7,-7,-5,1,1,3,4],[-2],[-10,-10,-7,0,1,3],[2]] 输出12 预期14
        int ans = 0;
        int hisMax = 0, hisMin = 0;
        int index = 0;
        for(int i = 0; i < arrays.size(); i++){
            if(arrays.get(i).size() > 0){
                index = i;
                hisMin = arrays.get(i).get(0);
                hisMax = arrays.get(i).get(arrays.get(i).size() - 1);
                break;
            }
        }
        for(int j = index + 1; j < arrays.size(); j++){
            if(arrays.get(j).size() > 0){
                ans = Math.max(ans, Math.max(Math.abs(arrays.get(j).get(0) - hisMax),
                        Math.abs(arrays.get(j).get(arrays.get(j).size() - 1) - hisMin)));
                hisMax = Math.max(hisMax, arrays.get(j).get(arrays.get(j).size() - 1));
                hisMin = Math.min(hisMin, arrays.get(j).get(0));
            }
        }

        return ans;

    }

    /**
     * 645. 错误的集合
     * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     * 输入: nums = [1,2,2,4] 输出: [2,3]
     * 1.给定数组的长度范围是 [2, 10000]。     2.给定的数组是无序的。
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> sets = new HashSet<>();
        int sum = 0;
        for(int num : nums){
            if(!sets.add(num)){
                ans[0] = num;// 重复的数字
            }else{
                sum ^= num;
            }
        }
        for(int i = 1; i <= nums.length; i++){
            sum ^= i;
        }
        ans[1] = sum;
        return ans;
    }

    /**
     * 1002. 查找常用字符
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
     * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。你可以按任意顺序返回答案。
     * 输入：["bella","label","roller"]    输出：["e","l","l"]；       输入：["cool","lock","cook"]    输出：["c","o"]
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < A[0].length(); i++){
            hash.put(A[0].charAt(i), hash.getOrDefault(A[0].charAt(i), 0) + 1);
        }
        Map<Character, Integer> temp = new HashMap<>();
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[i].length(); j++) {
                Character value = A[i].charAt(j);
                if(hash.containsKey(value) && hash.get(value) > 0){
                    hash.put(value, hash.get(value) - 1);
                    temp.put(value, temp.getOrDefault(value, 0) + 1);
                }
            }
            hash = temp;
            temp = new HashMap<>();
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : hash.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                ans.add(entry.getKey() + "");
            }
        }
        return ans;
    }

    /**
     * 387. 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * s = "leetcode"   返回 0
     * s = "loveleetcode"  返回 2
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int ans = -1;
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(hash.get(s.charAt(i)) == 1){
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 202. 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     * 输入：19    输出：true     解释：1^2 + 9^2 = 82; 8^2 + 2^2 = 68; 6^2 + 8^2 = 100; 1^2 + 0^2 + 0^2 = 1
     * @param n
     * @return
     */
    static Set<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        int num = 0;
        while(n != 0){
            num += (n % 10) * (n % 10);
            n = n / 10;
        }
        if(!set.add(num)){//递归终止符，防止陷入死循环
            return false;
        }
        if(num == 1){
            return true;
        }
        return isHappy(num);
    }

    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * s = "abaccdeff"  返回 "b"      s = ""  返回 " "              0 <= s 的长度 <= 50000
     * @param s
     * @return
     */
    public char firstUniqChar0(String s) {
        Map<Character, Boolean> hash = new LinkedHashMap<>();
        for(char ch : s.toCharArray()){
            hash.put(ch, !hash.containsKey(ch));
        }
        for(Map.Entry<Character, Boolean> entry : hash.entrySet()){
            if(entry.getValue()){
                return entry.getKey();
            }
        }
        return ' ';
    }

    /**
     * 1496. 判断路径是否相交
     * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
     * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
     * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
     * 输入：path = "NES"  输出：false    解释：该路径没有在任何位置相交。
     * 输入：path = "NESWW"    输出：true     解释：该路径经过原点两次。
     * 1 <= path.length <= 10^4         path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(getHash(x, y));
        for(int i = 0; i < path.length(); i++){
            if('N' == path.charAt(i)){
                x++;
            }else if('S' == path.charAt(i)){
                x--;
            }else if('E' == path.charAt(i)){
                y++;
            }else if('W' == path.charAt(i)){
                y--;
            }
            if(!set.add(getHash(x, y))){
                return true;
            }
        }
        return false;
    }

    // 保证key不重复，防止hash冲突
    public int getHash(int x, int y){
        // 1 <= path.length <= 10^4     20001 = 10^4(正) + 10^4（负） + 1(0)
        return x * 20001 + y;
    }

    public static void main(String[] args){
        System.out.println(isHappy(1));
//        System.out.println(countPrimes(4));
//        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));

      /*  List<Integer> subList1 = new ArrayList(){{add(1);add(2);add(3);}};
        List<Integer> subList2 = new ArrayList(){{add(4);add(5);}};
        List<Integer> subList3 = new ArrayList(){{add(1);add(2);add(3);}};
        List<List<Integer>> list = new ArrayList(){{add(subList1); add(subList2); add(subList3);}};
        // [[-8,-7,-7,-5,1,1,3,4],[-2],[-10,-10,-7,0,1,3],[2]] 输出12 预期14
       System.out.println(maxDistance(list));*/

//       System.out.println(findErrorNums(new int[]{37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5}));

//        System.out.println(commonChars(new String[]{"bella","label","roller"}));

    }

}
