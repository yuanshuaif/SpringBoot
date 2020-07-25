package com.lsj.springboot.Util.arithmetic.day200720;


/**
 * 题目2：2数相加
 */
public class NodeAdd {

    public static void main(String[] args){

//        Node a = new Node(2);
//        Node b = new Node(4);
//        Node c = new Node(3);
//        a.next = b;
//        b.next = c;
//
//        Node x = new Node(5);
//        Node y = new Node(6);
//        Node z = new Node(4);
//        x.next = y;
//        y.next = z;

//        Node a = new Node(2);
//        Node b = new Node(4);
//        Node c = new Node(3);
//        a.next = b;
//        b.next = c;
//
//        Node x = new Node(5);
//        Node y = new Node(6);
//        x.next = y;


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

        System.out.println(addNode(a, x));

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
}


