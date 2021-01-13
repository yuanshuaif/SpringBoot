package com.lsj.springboot.Util.arithmetic.day200812.listNode;


import java.io.*;
import java.util.*;

/**
 * * 链表的插入时间复杂度 o(1)，查询复杂度o(n);
 * * 顺序表的插入复杂度o(logn)，查询复杂度o(1);
 *
 * 题目2：2数相加
 * 双指针
 *
 * 题目21：链表合并(剑指 Offer 25. 合并两个排序的链表)
 * 双指针
 *
 * 206.链表翻转
 * 迭代
 *
 * 203. 移除链表元素
 *
 * 234. 回文链表
 * 双指针
 *
 * 83. 删除排序链表中的重复元素
 *
 * 141. 环形链表
 * 快慢指针
 *
 * 160. 相交链表
 *
 * Offer 22(面试题 02.02)返回倒数第 k 个节点
 * 双指针、滑动窗口
 *
 * Offer 06. 从尾到头打印链表
 *
 * 面试题 02.01. 移除重复节点
 *
 * 876. 链表的中间结点
 * 快慢指针
 *
 * 148. 排序链表（归并排序）
 *
 * 147. 对链表进行插入排序
 *
 * 86. 分隔链表
 *
 * 1474. 删除链表 M 个节点之后的 N 个节点
 *
 * 1290. 二进制链表转整数
 *
 * 19. 删除链表的倒数第N个节点
 *
 * 61. 旋转链表
 *
 * 445. 两数相加 II
 *
 * 24. 两两交换链表中的节点
 *
 * 82. 删除排序链表中的重复元素 II
 *
 * 369. 给单链表加一
 *
 * 143. 重排链表
 *
 * 328. 奇偶链表
 *
 * 142. 环形链表 II
 *
 * 92. 反转链表 II
 */
public class LinkedList {

    /**
     * 题目2：2数相加
     * 2个非空的非负整数，逆序存储，一个节点只能存储一位，2数相加得到一个新的链表。(2->4->3) + (5->6->4) 输出 7->0->8 342+465=807
     * @param a
     * @param b
     * @return
     */
    public static ListNode addNode(ListNode a, ListNode b){
        ListNode mergeNode = new ListNode(0);
        ListNode curNode = mergeNode;
        int culValue = 0;
        while(a != null || b != null || culValue > 0){// curValue > 0 解决相加进位的问题
            curNode.next = new ListNode(0);
            curNode = curNode.next;
            if(a != null){
                culValue += a.val;
                a = a.next;
            }
            if(b != null){
                culValue += b.val;
                b = b.next;
            }

            int cur = culValue % 10;
            culValue /= 10;
            curNode.val = cur;
        }
        return mergeNode.next;
    }

    /**
     * 21.有序链表合并(剑指 Offer 25. 合并两个排序的链表)
     * 返回一个有序的Node
     * 1.创建一个对象，给定2个指针，一个指针负责移动（先给下一个节点赋值，然后指针执行下一个节点），一个指针指向原来的位置确保输出改变后的对象
     * 空间复杂度O(1),时间复杂度O(m+n)
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeNode(ListNode a, ListNode b){
        ListNode mergeNode = new ListNode(0);
        ListNode curNode = mergeNode;
        while(a != null || b != null){
            if(b == null){
                curNode.next = a;
                break;
            }else if(a == null){
                curNode.next = b;
                break;
            }
            if(a.val > b.val) {
                curNode.next = b;
                curNode = curNode.next;
                b = b.next;
            }else if(a.val < b.val){
                curNode.next = a;
                curNode = curNode.next;
                a = a.next;
            }else if(a.val == b.val){
                curNode.next = a;
                curNode = curNode.next;
                a = a.next;
                curNode.next = b;
                curNode = curNode.next;
                b = b.next;
            }
        }

        return mergeNode.next;
    }

    /**
     * 206.链表翻转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 递归法
//        if(head == null || head.next == null)
//            return head;
//        listNode reverseNode  = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return reverseNode;

        // 迭代法
        ListNode temp = null;
        while(head != null){
            ListNode next = head.next;
            head.next = temp;// 对象关联
            temp = head;// 指针移动
            head = next;
        }
        return temp;
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。    输入: 1->2->6->3->4->5->6, val = 6     输出: 1->2->3->4->5
     * @param head
     * @param val
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 把头节点匹配到的元素全部删掉
        while (head != null){
            if(head.val == val){
                head = head.next;
            }else {
                break;
            }
        }
        // 比较头节点的下一个节点的元素值是否能匹配到
        ListNode temp = head;
        while(head != null){
            if(head.next != null && head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return temp;
    }

    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。输入: 1->2 输出: false；       输入: 1->2->2->1 输出: true
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        boolean flag = true;
       /* // 方法一、克隆一个对象与反转后的对象每个节点都进行对比，leetcode不支持深克隆的相关类所以暂时注释掉
        listNode orignalNode = (listNode)deepClone(head);
        listNode reverseNode = reverseList(head);
        while(reverseNode != null){
            if(reverseNode.val != orignalNode.val){
                flag = false;
                break;
            }
            reverseNode = reverseNode.next;
            orignalNode = orignalNode.next;
        }*/

        // 方法二、将链表中的元素取出依次放到数组中,使用双指针
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Integer[] chars = list.toArray(new Integer[0]);
        if(chars.length < 2){
            return true;
        }
        for(int i = 0; i < chars.length / 2; i++){
            if((int)chars[i] != (int)chars[chars.length - i -1]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 深克隆
     * @param node
     * @return
     */
    public static Object deepClone(ListNode node) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();//字节流对象
            ObjectOutputStream oos = new ObjectOutputStream(bos);//开始转换该对象
            oos.writeObject(node);//写到当前类，当然也可以写入文件
            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());//字节输出流
            ObjectInputStream ois = new ObjectInputStream(bais);//输出该对象
            return (Object) ois.readObject();//读出对象，实现新对象的生成
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。输入: 1->1->2 输出: 1->2;    输入: 1->1->2->3->3 输出: 1->2->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
       /* //1.将值压到栈里，得到无重复的节点
        if(head == null || head.next == null){
            return head;
        }
        Stack<listNode> stack = new Stack<>();
        while(head != null){
            listNode next = head.next;
            head.next = null;
            if(stack.isEmpty()){
                stack.push(head);
            }else{
                if(stack.peek().val != head.val){
                    stack.push(head);
                }
            }
            head = next;
        }
        //2.将节点从栈中取出得到一个新的Node
        listNode result = null;
        while(!stack.isEmpty()){
            listNode temp = stack.pop();
            temp.next = result;
            result = temp;
        }
        return result;*/

        // 如果下一个节点的值与自身节点的值不相等，则删除下一个节点
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = head;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return result;
    }

    /**
     * 141. 环形链表（数值相等）
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 快慢指针
        if(head == null || head.next == null){
            return false;
        }
        ListNode first = head.next;
        ListNode second = head.next.next;
        while(first != null && second != null){
            if(first.val == second.val){
                return true;
            }
            first = first.next;
            if(second.next == null){
                return false;
            }
            second = second.next.next;
        }
        return false;
    }

    /**
     * 160. 相交链表
     * 找到两个单链表相交的起始节点。（引用是否相等）（默认一定相交）
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

     * 让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。为此，我们必须消除两个链表的长度差
     * 1.指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 2.如果 pA 到了末尾，则 pA = headB 继续遍历
     * 3.如果 pB 到了末尾，则 pB = headA 继续遍历
     * 4.A + B = B + A 消除长度差
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(headA != headB){
            headA = headA == null ? b : headA.next;
            headB = headB == null ? a : headB.next;
        }
        return headB;
    }

    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。输入： 1->2->3->4->5 和 k = 2    输出： 4
     * 解题思路：类似于滑动窗口
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
       /* // 第一步将链表中的节点依次压入栈中
        Stack<listNode> stack = new Stack<>();
        while(head != null){
            listNode next = head.next;
            head.next = null;
            stack.push(head);
            head = next;
        }
        // 取除第i个节点
        listNode result = null;
        for(int i = 0; i < k; i++){
            result = stack.pop();
        }
        return result.val;*/

       ListNode p = head;
       for(int i = 0; i < k; i++){
           p = p.next;
       }
       while(p != null){
           p = p.next;
           head = head.next;
       }
       return head.val;
    }

    /**
     * Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 输入：head = [1,3,2]   输出：[2,3,1]
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        // 第一步将链表中的节点依次压入栈中
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            ListNode next = head.next;
            head.next = null;
            stack.push(head);
            head = next;
        }
        // 第二步依次取出节点的值组成数组返回
        int len = stack.size();
        int[] reverse = new int[len];
        for(int i = 0; i < len; i++){
            reverse[i] = stack.pop().val;
        }
        return reverse;
    }

    /**
     * 面试题 02.01. 移除重复节点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。输入：[1, 2, 3, 3, 2, 1] 输出：[1, 2, 3]
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int before, after = 0;
        Set<Integer> set = new HashSet<>();
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(head != null){
            before = set.size();
            set.add(head.val);
            after = set.size();
            if(before != after){
                ListNode next = head.next;
                head.next = null;
                temp.next = head;
                head = next;
                temp = temp.next;
            }else{
                head = head.next;
            }
        }
        return result.next;
    }

    /**
     * 876. 链表的中间结点
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。 如果有两个中间结点，则返回第二个中间结点。
     * 输入：[1,2,3,4,5]   输出：此列表中的结点 3 (序列化形式：[3,4,5]);   输入：[1,2,3,4,5,6] 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        // 快慢指针
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){// 奇数结束
            p = p.next;
            if(q.next == null){// 偶数结束
                return p;
            }else {
                q = q.next.next;
            }
        }
        return p;
    }

    /**
     * 148. 排序链表(归并排序)
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。输入: -1->5->3->4->0       输出: -1->0->3->4->5
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        // 归并排序
        if(head == null || head.next == null){
            return head;
        }
        // 使用快慢指针找到分割点
        ListNode soft = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            soft = soft.next;
            fast = fast.next.next;
        }
        ListNode mid = soft.next;
        soft.next = null;
        // 左右递归至终结点
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // 左右2边进行merge合并
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        temp.next = left != null ? left : right;
        return ans.next;
    }

    /**
     * 147. 对链表进行插入排序
     * 插入排序算法：
     * 1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。重复直到所有输入数据插入完为止。
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        // 插入排序(链表插入排序与数组插入排序的区别：链表从前往后；数组从后往前)
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode ans = new ListNode(0);
        ans.next = head;
        while(cur != null){
            if(pre.val <= cur.val){//1.不需要移动
                pre = pre.next;
                cur = cur.next;
            }else{
                ListNode temp = ans;
                while(temp.next.val < cur.val){// temp.next就是插入的位置
                    temp = temp.next;
                }
                pre.next = cur.next;// 断开原来的位置
                // 链接到新的位置
                cur.next = temp.next;
                temp.next = cur;
                // cur指针向下移动
                cur = pre.next;
            }
        }
        return ans.next;
    }

    /**
     * 86. 分隔链表
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode min = new ListNode(0);
        ListNode cur = min;
        ListNode max = new ListNode(0);
        max.next = head;
        head = max;
        while(head.next != null){
            if(head.next.val < x){
                ListNode next = head.next;
                head.next = head.next.next;
                next.next = null;// 拿到next
                cur.next = next;
                cur = cur.next;
            }else{
                head = head.next;
            }
        }
        cur.next = max.next;
        return min.next;
    }

    /**
     * 1474. 删除链表 M 个节点之后的 N 个节点
     * 给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
     * 开始时以头节点作为当前节点；保留以当前节点开始的前 m 个节点；删除接下来的 n 个节点；重复步骤 2 和 3, 直到到达链表结尾；在删除了指定结点之后, 返回修改过后的链表的头节点.

         输入: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
         输出: [1,2,6,7,11,12]
         解析: 保留前(m = 2)个结点,  也就是以黑色节点表示的从链表头结点开始的结点(1 ->2).
         删除接下来的(n = 3)个结点(3 -> 4 -> 5), 在图中以红色结点表示.
         继续相同的操作, 直到链表的末尾.
         返回删除结点之后的链表的头结点.

         输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
         输出: [1,5,9]
         解析: 返回删除结点之后的链表的头结点.

         输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
         输出: [1,2,3,5,6,7,9,10,11]

     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode ans = head;
        while(head != null){
            for(int i = 0; i < m - 1 && head != null; i++){// 移动m-1（head == null m还没走完）
                head = head.next;
            }
            for(int j = 0; j < n && head != null; j++){
                if(head.next != null){
                    head.next = head.next.next;
                }else{// n没走完结束
                    head.next = null;
                }
            }
            if(head != null){// 进入下一次循环
                head = head.next;
            }
        }
        return ans;
    }

    /**
     * 1290. 二进制链表转整数
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。请你返回该链表所表示数字的 十进制值 。
     * 输入：head = [1,0,1]      输出：5      解释：二进制数 (101) 转化为十进制数 (5)
     * 输入：head = [0]    输出：0        输入：head = [1]    输出：1
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while(head != null){
            sum = (sum << 1) + head.val;
            head = head.next;
        }
        return sum;
    }

    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2. 当删除了倒数第二个节点后，链表变为 1->2->3->5. 给定的 n 保证是有效的。 n->(1,5)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*listNode safe = head;
        listNode fast = head;
        int i = 1;
        int len = 0;// 记录链表长度
        while(fast != null){
            len++;
            if(i <= n){// 移动n个节点
                fast = fast.next;
                i++;
                continue;
            }
            if(fast.next == null){
                safe.next = safe.next.next;
                break;
            }
            safe = safe.next;
            fast = fast.next;
        }
        if(len == n){// 头节点删除
            head = head.next;
        }

        return head;
        */
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode soft = ans;
        ListNode fast = ans;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            soft = soft.next;
            fast = fast.next;
        }
        if(soft.next != null) {
            soft.next = soft.next.next;
        }
        return ans.next;
    }

    /**
     * 61. 旋转链表
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * 输入: 1->2->3->4->5->NULL, k = 2   输出: 4->5->1->2->3->NULL
     * 解释:向右旋转 1 步: 5->1->2->3->4->NULL    向右旋转 2 步: 4->5->1->2->3->NULL
     * 输入: 0->1->2->NULL, k = 4     输出: 2->0->1->NULL
     * 解释: 向右旋转 1 步: 2->0->1->NULL     向右旋转 2 步: 1->2->0->NULL      向右旋转 3 步: 0->1->2->NULL     向右旋转 4 步: 2->0->1->NULL
     *  第一步：尾结点连到头结点，得到链表长度n
     *  第二步：n - k % n新的头结点，n - k % n -1 新的尾结点
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int n = 1;
        ListNode oldTail = head;
        while(oldTail.next != null){
            oldTail = oldTail.next;
            n++;
        }
        oldTail.next = head;
        ListNode newTail = head;
        ListNode newHead = head.next;
        for(int i = 0; i < n - k % n -1; i++){
            newTail = newTail.next;
            newHead = newHead.next;
        }
        newTail.next = null;
        return newHead;
    }

    /**
     * 445. 两数相加 II
     * 给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * 进阶：如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)    输出：7 -> 8 -> 0 -> 7
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int curValue = 0;
        ListNode mergeNode = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty() || curValue > 0){
            curValue += !s1.isEmpty() ? s1.pop() : 0;
            curValue += !s2.isEmpty() ? s2.pop() : 0;
            ListNode curNode = new ListNode(0);
            curNode.val = curValue % 10;
            curValue = curValue / 10;
            // 将curNode挂到mergeNode节点上
            curNode.next = mergeNode.next;
            mergeNode.next = curNode;
        }
        return  mergeNode.next;
    }

    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode cur = ans;
        while(head != null && head.next != null){
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = head;
            cur.next = next;
            head = head.next;
            cur = cur.next.next;
        }
        return ans.next;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 输入: 1->2->3->3->4->4->5   输出: 1->2->5；        输入: 1->1->1->2->3     输出: 2->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode cur = ans;
        boolean flag = false;
        while(head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
                flag = true;
            }else{
                if(flag){
                    cur.next = head.next;
                    head = head.next;
                    flag = false;
                }else{
                    cur = cur.next;
                    head = head.next;
                }
            }
        }
        if(flag){
            cur.next = head.next;
        }
        return ans.next;
    }

    /**
     * 369. 给单链表加一
     * 用一个非空单链表来表示一个非负整数，然后将这个整数加一。你可以假设这个整数除了 0 本身，没有任何前导的 0。
     * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。       输入: [1,2,3]  输出: [1,2,4]
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        // 1.哨兵头节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode curNode = sentinel;
        // 2.找到最右侧不为9的节点
        while (head != null) {
            if(head.val != 9){
                curNode = head;
            }
            head = head.next;
        }
        // 3.最右侧不为9的节点+1
        curNode.val += 1;
        // 4.后继节点的值全部变成0
        curNode = curNode.next;
        while(curNode != null){
            curNode.val = 0;
            curNode = curNode.next;
        }
        return sentinel.val == 0 ? sentinel.next : sentinel;// 是否发生了进位
    }

    /**
     * 143. 重排链表
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.   给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * @param head
     */
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        ListNode temp = new ListNode(0);
        ListNode ans = temp;
        while(cur != stack.peek()){
            if(cur.next == stack.peek()){// 偶数最后节点的处理
                cur.next.next = null;
                temp.next = cur;
                break;
            }
            // 头节点塞值
            ListNode next = cur.next;
            cur.next = null;
            temp.next = cur;
            temp = temp.next;
            // 尾节点塞值
            ListNode end = stack.pop();
            end.next = null;
            temp.next = end;
            temp = temp.next;

            cur = next;
        }
        if(cur == stack.peek()){// 奇数最后节点的处理
            cur.next = null;
            temp.next = cur;
        }
        head = ans.next;
    }

    /**
     * 328. 奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * 输入: 1->2->3->4->5->NULL          输出: 1->3->5->2->4->NULL
     * 输入: 2->1->3->5->6->4->7->NULL    输出: 2->3->6->7->1->5->4->NULL
     * 注意：1.应当保持奇数节点和偶数节点的相对顺序。2.链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // 使用一个新链表装偶数节点
        ListNode evenAns = new ListNode(0);
        ListNode evenCur = evenAns;
        // 使用一个新链表装奇数节点
        ListNode oddAns = new ListNode(0);
        oddAns.next = head;
        while(head != null && head.next != null){
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = null;
            evenCur.next = next;
            if(head.next == null){// 偶数结尾
                head.next = evenAns.next;
                break;
            }else if(head.next.next == null){// 奇数结尾
                head.next.next = evenAns.next;
                break;
            }else {
                head = head.next;
                evenCur = evenCur.next;
            }
        }
        return oddAns.next;
    }

    /**
     * 142. 环形链表 II
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 说明：不允许修改给定的链表。
     * 输入：head = [3,2,0,-4], pos = 1    输出：tail connects to node index 1    解释：链表中有一个环，其尾部连接到第二个节点。
     * 输入：head = [1,2], pos = 0         输出：tail connects to node index 0    解释：链表中有一个环，其尾部连接到第一个节点。
     * 输入：head = [1], pos = -1          输出：no cycle                         解释：链表中没有环。
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/yi-yan-jiu-kan-dong-de-ti-jie-shuang-zhi-4sag/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        // a(开始位置->入环口) b（入环口走多少步相遇） c（再走多少步到达入环口） l（环长）
       /* 快慢指针相遇的节点，此时快指针走的距离：a+(b+c)n+b
        很容易理解b+c为环的长度，a为直线距离，b为绕了n圈之后又走了一段距离才相遇，所以相遇时走的总路程为a+(b+c)n+b，合并同类项得a+(n+1)b+nc。
        慢指针走的距离：a+(b+c)m+b,m代表圈数。
        然后我们设快指针得速度是慢指针的2倍,含义为相同时间内，快指针走过的距离是慢指针的2倍。
        **a+(n+1)b+nc=2[a+(m+1)b+mc]整理得a+b=(n-2m)(b+c)，**那么我们可以从这个等式上面发现什么呢？b+c
        为一圈的长度。也就是说a+b等于n-2m个环的长度。为了便于理解我们看一种特殊情况，当n-2m（l）等于1，那么a+b=b+c整理得，a=c此时我们只需重新释放两个指针，
        一个从head释放，一个从相遇点释放，速度相同，因为a=c所以他俩必会在环入口处相遇，则求得入口节点索引。*/

        if(head == null || head.next == null){
            return null;
        }
        // 1.设置快慢指针，快指针速度为慢指针的2倍,找出相遇点
        ListNode first = head.next;
        ListNode second = head.next.next;
        while(first != null && second != null){
            if(first == second){
                break;
            }
            first = first.next;
            if(second.next == null){
                return null;
            }
            second = second.next.next;
        }
        //  2.在head处和相遇点同时释放相同速度且速度为1的指针，两指针必会在环入口处相遇
        first = head;
        while(first != second){
            first = first.next;
            if(second == null) {
                return null;
            }
            second = second.next;
        }
        return first;
    }

    /**
     * 92. 反转链表 II
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。说明:1 ≤ m ≤ n ≤ 链表长度。
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4    输出: 1->4->3->2->5->NULL
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode cur = ans;
        int i = 1;
        while(head != null){
            if(i < m){// 移动前m - 1个节点
                head = head.next;
                cur = cur.next;
                i++;
                continue;
            }
            if(i < n){
                ListNode next = head.next;
                head.next = head.next.next;
                next.next = cur.next;
                cur.next = next;
                i++;
            }else{
                break;
            }
        }
        return ans.next;
    }

    public static void main(String[] args){

    /*    listNode a = new listNode(1);
        listNode b = new listNode(2);
        listNode c = new listNode(3);
        listNode d = new listNode(4);
        listNode e = new listNode(5);
        listNode f = new listNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        reorderList(a);*/

//        listNode a = new listNode(1, new listNode(4, new listNode(3, new listNode(2, new listNode(5, new listNode(2))))));
//        System.out.println(partition(a, 3));

        //返回一个有序的Node
        /*listNode a = new listNode(1);
        listNode b = new listNode(4);
        listNode c = new listNode(7);
        listNode d = new listNode(10);
        a.next = b;
        b.next = c;
        c.next = d;

        listNode x = new listNode(2);
        listNode o = new listNode(4);
        listNode y = new listNode(5);
        listNode z = new listNode(8);

        x.next = o;
        o.next = y;
        y.next = z;

        System.out.println(mergeNode(a, x));*/

        /* //删除链表中的节点
        listNode a = new listNode(2);
        listNode b = new listNode(4);
        listNode c = new listNode(3);
        a.next = b;
        b.next = c;

        listNode x = new listNode(0);
        listNode y = new listNode(6);
        listNode z = new listNode(4);
        x.next = y;
        y.next = z;

        System.out.println(addNode(a, x));*/

   /*     listNode a = new listNode(-129);
        listNode b = new listNode(-129);
//        listNode c = new listNode(2);
//        listNode d = new listNode(1);
        a.next = b;
//        b.next = c;
//        c.next = d;
        System.out.println(isPalindrome(a));*/

       /* listNode a = new listNode(-1, new listNode(5, new listNode(3, new listNode(4, new listNode(0)))));
        System.out.println(sortList(a));*/

        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseBetween(a, 1, 5));

    }
}

class ListNode implements Serializable {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "listNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}