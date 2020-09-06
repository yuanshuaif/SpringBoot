package com.lsj.springboot.Util.arithmetic.day200720;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 10326 on 2020/7/25.
 *
 * 104. 二叉树的最大深度
 * 递归
 *
 * 572. 另一个树的子树
 * 双递归
 *
 * 543. 二叉树的直径
 *
 * 110. 平衡二叉树
 *
 * 111. 二叉树的最小深度
 * 深度优先搜索
 *
 * 107. 二叉树的层次遍历 II
 * 广度优先搜索
 */
public class Tree {

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
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     * >>>>>>>>>>>>>>>>>>>>>>最近叶子节点
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null){
            min = Math.min(1 + minDepth(root.left), min);
        }
        if (root.right != null){
            min = Math.min(1 + minDepth(root.right), min);
        }
        return min;
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
        if (s.val != t.val) return false;
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

    /**
     * 110. 平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 107. 二叉树的层次遍历 II(102. 二叉树的层序遍历)
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * 例如：给定二叉树 [3,9,20,null,null,15,7],返回其自底向上的层次遍历为：[[15,7],[9,20],[3]]
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.size() != 0){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(0, temp);
        }
        return ans;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this(val, null, null);
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
