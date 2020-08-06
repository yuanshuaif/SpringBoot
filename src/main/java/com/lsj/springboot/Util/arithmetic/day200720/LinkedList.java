package com.lsj.springboot.Util.arithmetic.day200720;


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

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(removeElements(a, 2));

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
            if(a.value > b.value) {
                curNode.next = b;
                curNode = curNode.next;
                b = b.next;
            }else if(a.value < b.value){
                curNode.next = a;
                curNode = curNode.next;
                a = a.next;
            }else if(a.value == b.value){
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
                curValue += a.value;
                a = a.next;
            }

            if(b != null){
                curValue += b.value;
                b = b.next;
            }

            int cur = curValue % 10;
            curValue = curValue / 10;
            curNode.value = cur;
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
            if(head.value == val){
                head = head.next;
            }else {
                break;
            }
        }

        Node temp = head;

        // 比较头节点的下一个节点的元素值是否能匹配到
        while(head != null){
            if(head.next != null && head.next.value == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return temp;
    }
}

class Node {
    int value;
    Node next;
    Node(int value){
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

