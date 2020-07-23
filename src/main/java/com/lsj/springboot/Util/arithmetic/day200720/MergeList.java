package com.lsj.springboot.Util.arithmetic.day200720;


/**
 * 1.创建一个对象，给定2个指针，一个指针负责移动（先给下一个节点赋值，然后指针执行下一个节点），一个指针指向原来的位置确保输出改变后的对象
 */
public class MergeList {

    public static void main(String[] args){

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

        System.out.println(mergeNode(a, x));

    }

    /**
     * 返回一个有序的Node
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
                a = a.next;
                b = b.next;
            }
        }

        return mergeNode.next;
    }
}

class Node{
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
