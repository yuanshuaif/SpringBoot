package com.lsj.springboot.Util.arithmetic.day200720;


import java.io.*;
import java.util.*;

/**
 * * 链表的插入时间复杂度 o(1)，查询复杂度o(n);
 * * 顺序表的插入复杂度o(logn)，查询复杂度o(1);
 *
 * 题目2：2数相加
 * 双指针
 *
 * 链表合并
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
 * 返回倒数第 k 个节点
 * 双指针
 *
 * Offer 06. 从尾到头打印链表
 *
 * 876. 链表的中间结点
 * 快慢指针
 */
public class LinkedList {

    public static void main(String[] args){

       /* //返回一个有序的Node
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(7);
        Node d = new Node(10);
        a.next = b;
        b.next = c;
        c.next = d;

        Node x = new Node(2);
        Node o = new Node(4);
        Node y = new Node(5);
        Node z = new Node(8);

        x.next = o;
        o.next = y;
        y.next = z;

        System.out.println(mergeNode(a, x));*/

        /* //删除链表中的节点
        Node a = new Node(2);
        Node b = new Node(4);
        Node c = new Node(3);
        a.next = b;
        b.next = c;

        Node x = new Node(0);
        Node y = new Node(6);
        Node z = new Node(4);
        x.next = y;
        y.next = z;

        System.out.println(addNode(a, x));*/

        Node a = new Node(-129);
        Node b = new Node(-129);
//        Node c = new Node(2);
//        Node d = new Node(1);
        a.next = b;
//        b.next = c;
//        c.next = d;
        System.out.println(isPalindrome(a));

    }

    /**
     * 返回一个有序的Node
     * 1.创建一个对象，给定2个指针，一个指针负责移动（先给下一个节点赋值，然后指针执行下一个节点），一个指针指向原来的位置确保输出改变后的对象
     * 空间复杂度O(1),时间复杂度O(m+n)
     * @param a
     * @param b
     * @return
     */
    public static Node mergeNode(Node a, Node b){
        // TODO
        Node mergeNode = new Node(0);
        Node curNode = mergeNode;
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
                curNode.next = b;
                curNode = curNode.next;
                a = a.next;
                b = b.next;
            }
        }

        return mergeNode.next;
    }


    /**
     * 2个非空的非负整数，逆序存储，一个节点只能存储一位，2数相加得到一个新的链表
     * (2->4->3) + (5->6->4) 输出 7->0->8 342+465=807
     * @param a
     * @param b
     * @return
     */
    public static Node addNode(Node a, Node b){
        // TODO
        Node mergeNode = new Node(0);
        Node curNode = mergeNode;
        int curValue = 0;
        while(a != null || b != null || curValue > 0){
            curNode.next = new Node(0);
            curNode = curNode.next;

            if(a != null){
                curValue += a.val;
                a = a.next;
            }

            if(b != null){
                curValue += b.val;
                b = b.next;
            }

            int cur = curValue % 10;
            curValue = curValue / 10;
            curNode.val = cur;
        }

        return mergeNode.next;
    }

    /**
     * 206.链表翻转
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        // 递归法
//        if(head == null || head.next == null)
//            return head;
//        Node reverseNode  = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return reverseNode;

        // 迭代法
        Node temp = null;
        while(head != null){
            Node next = head.next;
            head.next = temp;// 对象关联
            temp = head;// 指针移动
            head = next;
        }
        return temp;
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.72%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了58.55%的用户
     * @param head
     * @param val
     */
    public static Node removeElements(Node head, int val) {

        // 把头节点匹配到的元素全部删掉
        while (head != null){
            if(head.val == val){
                head = head.next;
            }else {
                break;
            }
        }

        Node temp = head;

        // 比较头节点的下一个节点的元素值是否能匹配到
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
     *  请判断一个链表是否为回文链表。
     *  输入: 1->2 输出: false
     *  输入: 1->2->2->1 输出: true
     * @param head
     * @return
     */
    public static boolean isPalindrome(Node head) {
        boolean flag = true;
       /* // 方法一、克隆一个对象与反转后的对象每个节点都进行对比，leetcode不支持深克隆的相关类所以暂时注释掉
        Node orignalNode = (Node)deepClone(head);
        Node reverseNode = reverseList(head);
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
    public static Object deepClone(Node node) {
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
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 输入: 1->1->2 输出: 1->2;    输入: 1->1->2->3->3 输出: 1->2->3
     * @param head
     * @return
     */
    public Node deleteDuplicates(Node head) {
       /* //1.将值压到栈里，得到无重复的节点
        if(head == null || head.next == null){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        while(head != null){
            Node next = head.next;
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
        Node result = null;
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            temp.next = result;
            result = temp;
        }
        return result;*/

        // 如果下一个节点的值与自身节点的值不相等，则删除下一个节点
        if(head == null || head.next == null){
            return head;
        }
        Node result = head;
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
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        // 快慢指针
        if(head == null || head.next == null){
            return false;
        }
        Node first = head.next;
        Node second = head.next.next;
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
     * 找到两个单链表相交的起始节点。（引用是否相等）
     * 让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。为此，我们必须消除两个链表的长度差
     * 1.指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 2.如果 pA 到了末尾，则 pA = headB 继续遍历
     * 3.如果 pB 到了末尾，则 pB = headA 继续遍历
     * 4.A + B = B + A 消除长度差
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }
        Node a = headA;
        Node b = headB;
        while(headA != headB){
            headA = headA == null ? b : headA.next;
            headB = headB == null ? a : headB.next;
        }
        return headB;
    }

    /**
     * 面试题 02.02. 返回倒数第 k 个节点
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(Node head, int k) {
       /* // 第一步将链表中的节点依次压入栈中
        Stack<Node> stack = new Stack<>();
        while(head != null){
            Node next = head.next;
            head.next = null;
            stack.push(head);
            head = next;
        }
        // 取除第i个节点
        Node result = null;
        for(int i = 0; i < k; i++){
            result = stack.pop();
        }
        return result.val;*/

       Node p = head;
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
    public int[] reversePrint(Node head) {
        // 第一步将链表中的节点依次压入栈中
        Stack<Node> stack = new Stack<>();
        int len = 0;
        while(head != null){
            Node next = head.next;
            head.next = null;
            stack.push(head);
            len++;
            head = next;
        }
        // 第二步依次取出节点的值组成数组返回
        int[] reverse = new int[len];
        for(int i = 0; i < len; i++){
            reverse[i] = stack.pop().val;
        }
        return reverse;
    }

    /**
     * 面试题 02.01. 移除重复节点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * 输入：[1, 2, 3, 3, 2, 1] 输出：[1, 2, 3]
     * @param head
     * @return
     */
    public Node removeDuplicateNodes(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        int before, after = 0;
        Set<Integer> set = new HashSet<>();
        Node result = new Node(0);
        Node temp = result;
        while(head != null){
            before = set.size();
            set.add(head.val);
            after = set.size();
            if(before != after){
                Node next = head.next;
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
     * 输入：[1,2,3,4,5]   输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 输入：[1,2,3,4,5,6] 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * @param head
     * @return
     */
    public Node middleNode(Node head) {
        // 快慢指针
        Node p = head;
        Node q = head.next;
        while(q != null){
            p = p.next;
            if(q.next == null){// 偶数
                return p;
            }else {// 奇数
                q= q.next.next;
            }
        }
        return p;
    }

    /**
     * 148. 排序链表
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * 输入: -1->5->3->4->0       输出: -1->0->3->4->5
     * @param head
     * @return
     */
    public Node sortList(Node head) {


        return null;
    }
}

class Node implements Serializable {
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}