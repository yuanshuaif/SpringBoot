package com.lsj.springboot.Util.arithmetic.day200720;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by 10326 on 2020/7/25.
 *
 * 104. 二叉树的最大深度
 * 递归
 *
 * 572. 另一个树的子树
 * 双递归
 *
 * 100. 相同的树
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
 *
 * 101. 对称二叉树
 *
 * 637. 二叉树的层平均值
 * 广度优先搜索
 *
 * 108. 将有序数组转换为二叉搜索树
 *
 * 112. 路径总和
 * 深度优先搜索
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * 深度优先搜索
 *
 * 106. 从中序与后序遍历序列构造二叉树
 * 深度优先搜索
 *
 * 226. 翻转二叉树
 *
 * 617. 合并二叉树
 *
 * 404. 左叶子之和
 *
 * 257. 二叉树的所有路径
 *
 * 94. 二叉树的中序遍历
 *
 * 144. 二叉树的前序遍历
 *
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 广度优先搜索
 *
 * 114. 二叉树展开为链表
 */
public class Tree {

    private static int ans = 0;

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
     * 100. 相同的树
     * 判断两棵树是否相同
     * 给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
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

    /**
     * 101. 对称二叉树
     * 给定一个二叉树，检查它是否是镜像对称的。例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
//        return isSymmetric(root, root);
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
//        if(l == null && r == null){
//            return true;
//        }
//        if(l == null || r == null){
//            return false;
//        }
//        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);

        // 广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(l);
        queue.offer(r);
        while(queue.size() != 0){
            TreeNode ll = queue.poll();
            TreeNode rr = queue.poll();
            if(ll == null && rr == null){
                continue;
            }
            if(ll == null || rr == null || ll.val != rr.val){
                return false;
            }
            queue.offer(ll.left);
            queue.offer(rr.right);
            queue.offer(ll.right);
            queue.offer(rr.left);
        }
        return true;
    }

    /**
     * 637. 二叉树的层平均值（广度优先搜索）
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11] 解释：第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.size() != 0){
            double sum = 0;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode cur =  queue.poll();
                sum += cur.val;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ans.add(sum / len);
        }
        return ans;
    }

    /**
     * 108. 将有序数组转换为二叉搜索树
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 给定有序数组: [-10,-3,0,5,9],一个可能的答案是：[0,-3,9,-10,null,5,null]，它可以表示下面这个高度平衡二叉搜索树：
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 以中间节点或者中间节点的左节点作为根节点
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }

    /**
     * 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * 说明: 叶子节点是指没有子节点的节点。给定如下二叉树，以及目标和 sum = 22，
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 根节点到叶子节点的总和为sum, 下一个子节点到叶子节点的总和 sum - 当前节点的值
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * 根据一棵树的前序遍历与中序遍历构造二叉树。注意:你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,15,7]    中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private Map<Integer, Integer> mapping;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
        // [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
        mapping = new HashMap<>();
        int len = inorder.length;
        for(int i = 0; i < len; i++){
            mapping.put(inorder[i], i);// 中序节点的值在哪个位置
        }
        return buildTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight){
            return null;
        }
        int rootVal = preorder[preorderLeft];// 根节点的值
        TreeNode root = new TreeNode(preorder[preorderLeft]);//构造根节点
        int inorderRoot = mapping.get(rootVal);// 中序节点的位置
        int leftNum = inorderRoot - inorderLeft;// 左子树的数量
        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftNum, inorderLeft, inorderRoot - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + leftNum + 1, preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * 根据一棵树的中序遍历与后序遍历构造二叉树。注意:你可以假设树中没有重复的元素。
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        mapping = new HashMap<>();
        int len = inorder.length;
        for(int i = 0; i < len; i++){
            mapping.put(inorder[i], i);// 中序节点的值在哪个位置
        }
        return buildTree2(postorder, inorder, 0, len - 1, 0, len - 1);
    }
    public TreeNode buildTree2(int[] postorder, int[] inorder, int postorderLeft, int postorderRight, int inorderLeft, int inorderRight) {
        if(postorderLeft > postorderRight){
            return null;
        }
        int rootVal = postorder[postorderRight];// 根节点的值
        TreeNode root = new TreeNode(rootVal);// 构造根节点
        int rootIndex = mapping.get(rootVal);// 根节点的值在中序数组里的位置
        int leftNum = rootIndex - inorderLeft;//左子树的数量
        root.left = buildTree2(postorder, inorder, postorderLeft, postorderLeft + leftNum - 1, inorderLeft, rootIndex - 1);
        root.right = buildTree2(postorder, inorder, postorderLeft + leftNum, postorderRight - 1, rootIndex + 1, inorderRight);
        return root;
    }

    /**
     * 226. 翻转二叉树
     *            4
               /   \
             2     7
           / \   / \
         1   3 6   9
              4
            /   \
           7     2
         / \   / \
        9   6 3   1
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // if(root == null || (root.left == null && root.right == null)){
        //     return root;
        // }else{
        //     TreeNode temp = root.left;
        //     root.left = root.right;
        //     root.right = temp;
        //     invertTree(root.left);
        //     invertTree(root.right);
        // }
        // return root;

        if(root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * 输入:Tree 1                     Tree 2
           1                         2
         / \                        / \
         3   2                     1   3
         /                           \   \
         5                             4   7
         输出:合并后的树:
              3
             / \
          4   5
         / \   \
         5   4   7
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }else if(t1 == null && t2 != null){
            return t2;
        }else if(t1 != null && t2 == null){
            return t1;
        }else{
            t1.val = t1.val + t2.val;
            TreeNode left = mergeTrees(t1.left, t2.left);
            TreeNode right = mergeTrees(t1.right, t2.right);
            t1.left = left;
            t1.right = right;
            return t1;
        }
    }

    /**
     * 404. 左叶子之和
            3
           / \
         9   20
            /  \
          15   7
     在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            ans += root.left.val;
        }
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);
        ans += leftValue + rightValue;
        return ans;
    }

    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。说明: 叶子节点是指没有子节点的节点。
     * 输入:                       输出: ["1->2->5", "1->3"]
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * @param root
     * @return
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        binaryTreePaths(root, res, new StringBuilder());
        return res;
    }

    public void binaryTreePaths(TreeNode root, List<String> res, StringBuilder sb) {
        if(root.left == null && root.right == null){
            sb.append(root.val);
            res.add(new StringBuilder(sb).toString());
            return;
        }
        sb.append(root.val);
        if(root.left != null){
            sb.append("->");
            binaryTreePaths(root.left, res, sb);
            sb.delete(sb.length() - 2 - String.valueOf(root.left.val).length(), sb.length());
        }
        if(root.right != null){
            sb.append("->");
            binaryTreePaths(root.right, res, sb);
            sb.delete(sb.length() - 2 - String.valueOf(root.right.val).length(), sb.length());
        }
        return;
    }

    /**
     * 94. 二叉树的中序遍历
     * 给定一个二叉树，返回它的中序 遍历。
     * 输入: [1,null,2,3]                 输出: [1,3,2]
             1
             \
             2
             /
             3
     * @param root
     * @return
     */
    // 递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     inorderTraversal(root, res);
    //     return res;
    // }
    // public void inorderTraversal(TreeNode root, List<Integer> res) {
    //     if(root == null){
    //         return;
    //     }
    //     inorderTraversal(root.left, res);
    //     res.add(root.val);
    //     inorderTraversal(root.right, res);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            root = temp.right;
        }
        return res;
    }

    /**
     *  144. 二叉树的前序遍历
     *  给定一个二叉树，返回它的前序 遍历。
     *  输入: [1,null,2,3]                 输出: [1,3,2]
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        preorderTraversal(root, res);
//        return res;
//    }
//
//    public void preorderTraversal(TreeNode root, List<Integer> res) {
//        if(root == null){
//            return;
//        }
//        res.add(root.val);
//        preorderTraversal(root.left, res);
//        preorderTraversal(root.right, res);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            root = temp.right;
        }
        return res;
    }

    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * 给定二叉树: [3,9,20,null,null,15,7],            返回：[3,9,20,15,7]
     *    3
         / \
         9  20
         /  \
         15   7
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.size() != 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tempNode =  queue.poll();
                temp.add(tempNode.val);
                if(tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if(tempNode.right != null){
                    queue.offer(tempNode.right);
                }
            }
        }
        int[] ans = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }

    /**
     * 114. 二叉树展开为链表
     * 给定一个二叉树，原地将它展开为一个单链表。
     *    1
         / \
         2   5
         / \   \
         3   4   6
     [1,null,2,null,3,null,4,null,5,null,6]
     * @param root
     */
    // public void flatten(TreeNode root) {
    //     List<TreeNode> temp = new ArrayList<>();
    //     preorderTraversal(root, temp);
    //     for(int i = 1; i < temp.size(); i++){
    //         TreeNode prev = temp.get(i - 1);
    //         prev.left = null;
    //         prev.right = temp.get(i);
    //     }
    // }
    //  public void preorderTraversal(TreeNode root, List<TreeNode> temp) {
    //      if(root != null){
    //          temp.add(root);
    //          preorderTraversal(root.left, temp);
    //          preorderTraversal(root.right, temp);
    //      }
    // }
    // 对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，
    // 然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，
    // 直到所有节点都处理结束。
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode next = cur.left;
                TreeNode preorder = next;
                while(preorder.right != null){
                    preorder = preorder.right;
                }
                preorder.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

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
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(2);
////        a.left = b;
//        a.right = b;
//        System.out.println(diameterOfBinaryTree(a));
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
