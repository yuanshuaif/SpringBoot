package com.lsj.springboot.Util.arithmetic.day200720;

/**
 * Created by 10326 on 2020/7/25.
 */
public class Solution {

    public static void main(String[] args){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(reverseList(a));
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

}
