package com.lsj.springboot.Util.arithmetic.day200720;

/**
 * Created by 10326 on 2020/7/25.
 *
 * 206.链表翻转
 * 迭代
 *
 * 104. 二叉树的最大深度
 * 递归
 *
 * 572. 另一个树的子树
 * 双递归
 *
 * 543. 二叉树的直径
 */
public class Solution {

    private static int ans = 0;

    public static void main(String[] args){
       /* Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;*/
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
//        a.left = b;
        a.right = b;
        System.out.println(diameterOfBinaryTree(a));
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
     * 104. 二叉树的最大深度
     * 递归
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 572. 另一个树的子树
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.value != t.value) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    /**
     * 543. 二叉树的直径
     *  给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     *  算法：计算左右子树的最大深度，树的直径 = 左子树深度 + 右子树深度
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)){
            return 0;
        }
        diameter(root);
        return ans;
    }


    public static int diameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }

}
