package com.lsj.springboot.arithmetic.tree;

import java.io.Serializable;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by 10326 on 2020/7/25.
 *
 * 广度优先搜索
 * ********************
 *
 * 107. 二叉树的层次遍历 II
 *
 * 101. 对称二叉树
 *
 * 637. 二叉树的层平均值
 *
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 103. 二叉树的锯齿形层次遍历
 *
 * 199. 二叉树的右视图
 *
 * 515. 在每个树行中找最大值
 *
 * 429. N叉树的层序遍历
 *
 * 1302. 层数最深叶子节点的和
 *
 * ********************
 *
 *
 * 深度优先搜索
 * ********************
 *
 * 104. 二叉树的最大深度
 *
 * 100. 相同的树
 *
 * 572. 另一个树的子树
 *
 * 543. 二叉树的直径
 *
 * 110. 平衡二叉树
 *
 * 111. 二叉树的最小深度
 *
 * 108. 将有序数组转换为二叉搜索树
 *
 * 109. 有序链表转换二叉搜索树
 *
 * 112. 路径总和
 *
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 226. 翻转二叉树
 *
 * 617. 合并二叉树
 *
 * 404. 左叶子之和
 *
 * 94. 二叉树的中序遍历
 *
 * 144. 二叉树的前序遍历
 *
 * 145. 二叉树的后序遍历
 *
 * 538. 把二叉搜索树转换为累加树
 * 1038. 从二叉搜索树到更大和树
 *
 * 530. 二叉搜索树的最小绝对差
 * 783. 二叉搜索树节点最小距离
 *
 * 701. 二叉搜索树中的插入操作
 *
 * 面试题 04.05. 合法二叉搜索树
 * 98. 验证二叉搜索树
 *
 * 114. 二叉树展开为链表
 *
 * 235. 二叉搜索树的最近公共祖先
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 *
 * 653. 两数之和 IV - 输入 BST
 *
 * 面试题 17.12. BiNode
 *
 * 1469. 寻找所有的独生节点

 * 236. 二叉树的最近公共祖先
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 *
 * ********************
 *
 *
 * 回溯算法
 * ********************
 *
 * 257. 二叉树的所有路径
 *
 * 113. 路径总和 II
 *
 * ********************
 */
public class Tree {

    /**
     * 广度优先搜索
     */
    class BFS{

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
         * 给定一个二叉树，检查它是否是镜像对称的。例如，二叉树 [1,2,2,3,4,4,3] 是对称的。但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的;
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
         * 剑指 Offer 32 - I. 从上到下打印二叉树
         * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
         * 给定二叉树: [3,9,20,null,null,15,7],            返回：[3,9,20,15,7]
         *    3
         *   / \
         *  9  20
         *  /   \
         * 15   7
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
         * 剑指 Offer 32 - III. 从上到下打印二叉树 III
         * 103. 二叉树的锯齿形层次遍历
         * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
         * 给定二叉树: [3,9,20,null,null,15,7]           [[3],[20,9],[15,7]]
         * 给定二叉树: [1,2,3,4,null,null,5]             [[1],[3,2],[4,5]]
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while(queue.size() != 0){
                LinkedList<Integer> temp = new LinkedList<>();
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(ans.size() % 2 == 0){// 偶数顺序输出
                        temp.addLast(node.val);
                    }else{//奇数逆序输出
                        temp.addFirst(node.val);
                    }
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
                ans.add(temp);
            }
            return ans;
        }

        /**
         * 199. 二叉树的右视图
         * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
         * 输入: [1,2,3,null,5,null,4]    输出: [1, 3, 4]
         * 输入: [1,2,3,null,5,null,null]    输出: [1, 3, 5]
         * @param root
         * @return
         */
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while(queue.size() != 0){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(i == size - 1){
                        ans.add(node.val);
                    }
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
            return ans;
        }

        /**
         * 515. 在每个树行中找最大值
         * 您需要在二叉树的每一行中找到最大的值。
         * 输入:1
         *    / \
         *   3   2
         *  / \   \
         * 5   3   9
         * 输出: [1, 3, 9]
         * @param root
         * @return
         */
        public List<Integer> largestValues(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while(queue.size() != 0){
                int max = Integer.MIN_VALUE;
                int len = queue.size();
                for(int i = 0; i < len; i++) {
                    TreeNode cur =  queue.poll();
                    max = Math.max(max, cur.val);
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                ans.add(max);
            }
            return ans;
        }

        /**
         * 429. N叉树的层序遍历
         * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。例如，给定一个 3叉树 :
         *            1
         *         / \  \
         *       3   2   4
         *      / \
         *     5  6
         * [[1],[3,2,4],[5,6]]
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderN(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> tempList = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    TreeNode tempNode = queue.poll();
                    tempList.add(tempNode.val);
                    List<TreeNode> children = tempNode.children;
                    if(children != null && children.size() != 0){
                        for(int j = 0; j < children.size(); j++){
                            queue.offer(children.get(j));
                        }
                    }

                }
                res.add(tempList);
            }
            return res;
        }

        /**
         * 1302. 层数最深叶子节点的和
         * 给你一棵二叉树，请你返回层数最深的叶子节点的和。                  bfs
         * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]         输出：15
         * @param root
         * @return
         */
        public int deepestLeavesSum(TreeNode root) {
            if(root == null){
                return 0;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int ans = 0;
            while(queue.size() != 0){
                int size = queue.size();
                ans = 0;
                for(int i = 0; i < size; i++){
                    TreeNode temp = queue.poll();
                    ans += temp.val;
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }
                }
            }
            return ans;
        }

    }

    /**
     * 深度优先搜索
     */
    class DFS{
        /**
         * 104. 二叉树的最大深度
         * 递归
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
         * 572. 另一个树的子树
         * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
         * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
         * @param s
         * @param t
         * @return
         */
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) return false;
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        /**
         * 543. 二叉树的直径
         *  给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
         *  算法：计算左右子树的最大深度，树的直径 = 左子树深度 + 右子树深度
         * @param root
         * @return
         */
        private int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null || (root.left == null && root.right == null)) return 0;
            diameter(root);
            return ans;
        }
        public int diameter(TreeNode root) {
            if(root == null) return 0;
            int left = diameter(root.left);
            int right = diameter(root.right);
            ans = Math.max(ans, left + right);// 每个节点都需要参与计算
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
            if(root == null) return true;
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        /**
         * 111. 二叉树的最小深度
         * 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
         * 说明: 叶子节点是指没有子节点的节点。>>>>>>>>>>>>>>>>>>>>>>最近叶子节点
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
           if (root == null){
               return 0;
           }else if (root.left == null && root.right == null){
               return 1;
           }
           int min = Integer.MAX_VALUE;
           if(root.left != null){
               min = Math.min(min, minDepth(root.left) + 1);
           }
           if(root.right != null){
               min = Math.min(min, minDepth(root.right) + 1);
           }
           return min;
        }

        /**
         * 108. 将有序数组转换为平衡二叉搜索树
         * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
         * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
         * 给定有序数组: [-10,-3,0,5,9],一个可能的答案是：[0,-3,9,-10,null,5,null]，它可以表示下面这个高度平衡二叉搜索树：
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            // 核心算法：以中间节点或者中间节点的左节点作为根节点
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }
        public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
            if(start > end){
                return null;
            }
            int mid = (end -start) / 2 + start;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, end);
            return root;
        }

        /**
         * 109. 有序链表转换二叉搜索树
         * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
         * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
         * 给定的有序链表： [-10, -3, 0, 5, 9],一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
         * @param head
         * @return
         */
        public TreeNode sortedListToBST(ListNode head) {
            return buildBST(head, null);
        }
        public TreeNode buildBST(ListNode left, ListNode right){
            if(left == right){
                return null;
            }
            ListNode mid = getMid(left, right);
            TreeNode ans = new TreeNode(mid.val);
            ans.left = buildBST(left, mid);
            ans.right = buildBST(mid.next, right);
            return ans;
        }
        // 链表使用快慢指针找到中间节点
        public ListNode getMid(ListNode left, ListNode right){
            ListNode slow = left;
            ListNode fast = left;
            while(fast != right && fast.next != right){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
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
            // 核心算法：根节点到叶子节点的总和为sum, 下一个子节点到叶子节点的总和 sum - 当前节点的值
            if(root == null) return false;
            if(root.left == null && root.right == null) return root.val == sum;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -root.val);
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
           /* if(preorder == null || preorder.length == 0) return null;
            int rootVal = preorder[0];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = -1;
            for(int i = 0; i < inorder.length; i++){
                if(rootVal == inorder[i]){
                    rootIndex = i;
                }
            }
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
            root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
            return root;*/
           // 1.通过map解决循环匹配的问题; 2.通过指针解决数组复制的问题;
           mapping = new HashMap<>();
           int len = preorder.length;
           for(int i = 0; i < inorder.length; i++){
               mapping.put(inorder[i], i);
           }
           return buildTree(preorder, inorder, 0, len - 1, 0, len - 1);
        }
        public TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
            if(preorderLeft > preorderRight)    return null;
            int rootVal = preorder[preorderLeft];// 根节点的值
            TreeNode root = new TreeNode(rootVal);//构造根节点
            int inorderIndex = mapping.get(rootVal);// 中序节点的位置
            int leftNum = inorderIndex - inorderLeft;// 左子树的数量
            root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + leftNum, inorderLeft, inorderIndex - 1);
            root.right = buildTree(preorder, inorder, preorderLeft + leftNum + 1, preorderRight, inorderIndex + 1, inorderRight);
            return root;
        }

        /**
         * 106. 从中序与后序遍历序列构造二叉树
         * 根据一棵树的中序遍历与后序遍历构造二叉树。注意:你可以假设树中没有重复的元素。
         * 后序遍历 postorder = [9,15,7,20,3]     中序遍历 inorder = [9,3,15,20,7]
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
         *          /   \
         *         2     7
         *        / \   / \
         *       1   3 6   9
         *         4
         *       /   \
         *      7     2
         *    / \   / \
         *   9   6 3   1
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
         *      1                         2
         *     / \                       / \
         *    3   2                     1   3
         *   /                           \   \
         *  5                             4   7
         * 输出:合并后的树:
         *        3
         *       / \
         *      4   5
         *     / \   \
         *    5   4   7
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
         * [-9,-3,2,null,4,4,0,-6,null,-5]
         * [1,2,3,4,5]
         *       3
         *      / \
         *     9  20
         *       /  \
         *      15   7
         * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
         * @param root
         * @return
         */
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            if(root.left != null && root.left.left == null && root.left.right == null) ans += root.left.val;
            return ans + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

        /**
         * 94. 二叉树的中序遍历
         * 给定一个二叉树，返回它的中序 遍历。
         * 输入: [1,null,2,3]                 输出: [1,3,2]
         *        1
         *        \
         *         2
         *        /
         *       3
         * @param root
         * @return
         */
       /*  递归
         public List<Integer> inorderTraversal(TreeNode root) {
             List<Integer> res = new ArrayList<>();
             inorderTraversal(root, res);
             return res;
         }
         public void inorderTraversal(TreeNode root, List<Integer> res) {
             if(root == null){
                 return;
             }
             inorderTraversal(root.left, res);
             res.add(root.val);
             inorderTraversal(root.right, res);
         }*/
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(stack.size() != 0 || root != null){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                TreeNode left = stack.pop();
                ans.add(left.val);
                root = root.right;
            }
            return ans;
        }

        /**
         *  144. 二叉树的前序遍历
         *  给定一个二叉树，返回它的前序 遍历。
         *  输入: [1,null,2,3]                 输出: [1,2,3]
         * @param root
         * @return
         */
        /*    public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> res = new ArrayList<>();
                preorderTraversal(root, res);
                return res;
            }

            public void preorderTraversal(TreeNode root, List<Integer> res) {
                if(root == null){
                    return;
                }
                res.add(root.val);
                preorderTraversal(root.left, res);
                preorderTraversal(root.right, res);
            }*/
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(stack.size() != 0 || root != null){
                while(root != null){
                    ans.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                TreeNode temp = stack.pop();
                root = temp.right;
            }
            return ans;
        }

        /**
         * 145. 二叉树的后序遍历
         * 给定一个二叉树，返回它的 后序 遍历。
         * 输入: [1,null,2,3]                 输出: [3,2,1]
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorderTraversal(root, res);
            return res;
        }
        public void postorderTraversal(TreeNode root, List<Integer> res) {
            if(root == null){
                return;
            }
            postorderTraversal(root.left, res);
            postorderTraversal(root.right, res);
            res.add(root.val);
        }

        /**
         * 538. 把二叉搜索树转换为累加树
         * 1038. 从二叉搜索树到更大和树
         * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
         * 输入: 原始二叉搜索树:
         *    5
         *  /   \
         * 2     13
         * 输出: 转换为累加树:
         *     18
         *   /   \
         * 20     13
         */
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            // 核心算法：逆序中序遍历
            if(root == null){
                return root;
            }
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }

        /**
         * 530. 二叉搜索树的最小绝对差
         * 783. 二叉搜索树节点最小距离
         * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
         * 输入：    输出：1     解释：最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
         *    1
         *     \
         *      3
         *     /
         *    2
         * @param root
         * @return
         */
        public int getMinimumDifference(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            int pre = list.get(0);
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < list.size(); i++){
                min = Math.min(min, list.get(i) - pre);
                pre = list.get(i);
            }
            return min;
        }
        public void inorderTraversal(TreeNode root, List<Integer> list){
            if(root != null){
                inorderTraversal(root.left, list);
                list.add(root.val);
                inorderTraversal(root.right, list);
            }
        }

        /**
         * 701. 二叉搜索树中的插入操作
         * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
         * 输入数据保证：1.新值和原始二叉搜索树中的任意节点值都不同；2.每个节点都有一个唯一整数值
         * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
         * 思路与算法：
         *         首先回顾二叉搜索树的性质：对于任意节点root 而言，左子树（如果存在）上所有节点的值均小于root.val，右子树（如果存在）上所有节点的值均大于root.val，且它们都是二叉搜索树。
         *         因此，当将val 插入到以root 为根的子树上时，根据val 与 root.val 的大小关系，就可以确定要将 val 插入到哪个子树中。
         *         如果该子树不为空，则问题转化成了将val 插入到对应子树上。否则，在此处新建一个以val 为值的节点，并链接到其父节点root 上。
         * 给定二叉搜索树:    和 插入的值: 5
         *         4
         *        / \
         *       2   7
         *      / \
         *     1   3
         * 你可以返回这个二叉搜索树:
         *          4
         *        /   \
         *       2     7
         *      / \   /
         *     1   3 5
         * @param root
         * @param val
         * @return
         */
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null){
                TreeNode newNode = new TreeNode(val);
                return newNode;
            }else if(root.val > val){
                root.left = insertIntoBST(root.left, val);
            }else if(root.val < val){
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }

        /**
         * 面试题 04.05. 合法二叉搜索树
         * 98. 验证二叉搜索树
         * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
         * [1,1] false ;   [2,1,3]  true ;  [10,5,15,null,null,6,20]  false; [3,1,5,0,2,4,6] true;[-2147483648,null,2147483647]  false
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
           /* List<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            int pre = list.get(0);
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) <= pre){
                    return false;
                }
                pre = list.get(i);
            }
            return true;*/
            if(root == null)     return true;
            return isValidBST(root.left, (long)Integer.MIN_VALUE - 1, root.val) &&
                    isValidBST(root.right, root.val, (long)Integer.MAX_VALUE + 1);
        }
        public boolean isValidBST(TreeNode root, long min, long max) {
            if(root == null)    return true;
            if(root.val >= max || root.val <= min)  return false;
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }

        /**
         * 114. 二叉树展开为链表
         * 给定一个二叉树，原地将它展开为一个单链表。
         *     1
         *    / \
         *   2   5
         *  / \   \
         * 3   4   6
         * [1,null,2,null,3,null,4,null,5,null,6]
         * @param root
         */
       /*  public void flatten(TreeNode root) {
             List<TreeNode> temp = new ArrayList<>();
             preorderTraversal(root, temp);
             for(int i = 1; i < temp.size(); i++){
                 TreeNode prev = temp.get(i - 1);
                 prev.left = null;
                 prev.right = temp.get(i);
             }
         }
          public void preorderTraversal(TreeNode root, List<TreeNode> temp) {
              if(root != null){
                  temp.add(root);
                  preorderTraversal(root.left, temp);
                  preorderTraversal(root.right, temp);
              }
         }*/
        public void flatten(TreeNode root) {
            // 1.对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点。
            // 2.然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。
            // 3.对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
            TreeNode cur = root;
            while (cur != null){
                TreeNode left = cur.left;
                TreeNode next = left;
                if(left != null){
                    while(left.right != null){
                        left = left.right;
                    }
                    left.right = cur.right;
                    cur.right = next;
                    cur.left = null;
                }
                cur = cur.right;
            }
        }

        /**
         * 235. 二叉搜索树的最近公共祖先
         * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
         * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
         * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
         * 例如，给定如下二叉搜索树: [6,2,8,0,4,7,9,null,null,3,5,null,null,null,null]
         * 输入:p = 2, q = 8   输出: 6   解释: 节点 2 和节点 8 的最近公共祖先是 6。
         * 输入:p = 2, q = 4   输出: 2   解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
         * 注：1.所有节点的值都是唯一的。2.p、q 为不同节点且均存在于给定的二叉搜索树中。
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* 核心算法
        1.我们从根节点开始遍历；
        2.如果当前节点的值大于 p 和 q 的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
        3.如果当前节点的值小于 p 和 q 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
        4.如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，p 和 q 要么在当前节点的不同的子树中，要么其中一个就是当前节点。*/
            while(root != null){
                if(root.val > p.val && root.val > q.val){
                    root = root.left;
                }else if(root.val < p.val && root.val < q.val){
                    root = root.right;
                }else {
                    break;
                }
            }
            return root;
        }

        /**
         * 653. 两数之和 IV - 输入 BST
         * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
         * 输入:              Target = 9               输出: True
         *     5
         *    / \
         *   3   6
         *  / \   \
         * 2   4   7
         *
         * 输入:              Target = 28              输出: False
         *     5
         *    / \
         *   3   6
         *  / \   \
         * 2   4   7
         * @param root
         * @param k
         * @return
         */
        public boolean findTarget(TreeNode root, int k) {
          /* 核心算法
            1.在本方法中利用 BST 的性质，BST 的中序遍历结果是按升序排列的。因此，中序遍历给定的 BST，并将遍历结果存储到 list 中。
            2.遍历完成后，使用两个指针 l 和 r 作为 list 的头部索引和尾部索引。然后执行以下操作：
            3.检查 l 和 r 索引处两元素之和是否等于 k。如果是，立即返回 True。
            4.如果当前两元素之和小于 k，则更新 l 指向下一个元素。这是因为当我们需要增大两数之和时，应该增大较小数。
            5.如果当前两元素之和大于 k，则更新 r 指向上一个元素。这是因为当我们需要减小两数之和时，应该减小较大数。
            6.重复步骤一至三，直到左指针 l 大于右指针 r。
            7.如果左指针 l 到右指针 r 的右边，则返回 False。*/
            List<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            int left = 0;
            int right = list.size() - 1;
            while(left < right){
                if(list.get(left) + list.get(right) == k){
                    return true;
                }else if(list.get(left) + list.get(right) > k){
                    right--;
                }else if(list.get(left) + list.get(right) < k){
                    left++;
                }
            }
            return false;
        }

        /**
         * 面试题 17.12. BiNode
         * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
         * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
         * 返回转换后的单向链表的头节点。
         * [5,2,7,1,4,6,8,0,null,3]             [0,null,1,null,2,null,3,null,4,null,5,null,6,null,7,null,8]
         */
        /*TreeNode head = new TreeNode(-1);
        TreeNode pre = null;
        public TreeNode convertBiNode(TreeNode root) {
            helper(root);
            return head.right;
        }
        public void helper(TreeNode root) {
            if(root == null){
                return;
            }
            helper(root.left);
            if(pre == null){
                pre = root;
                head.right = root;
            }else{
                pre.right = root;
                pre = pre.right;
            }
            root.left = null;
            helper(root.right);
        }*/
        public TreeNode convertBiNode(TreeNode root) {
            List<TreeNode> nodes = new ArrayList<>();
            TreeNode head = new TreeNode(-1);
            TreeNode ans = head;
            helper(root, nodes);
            for(TreeNode node : nodes) {
                head.right = node;
                head = head.right;
            }
            return ans.right;
        }
        public void helper(TreeNode root, List<TreeNode> nodes) {
            if(root == null){
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = null;
            helper(left, nodes);
            nodes.add(root);
            helper(right, nodes);
        }

        /**
         * 1469. 寻找所有的独生节点
         * 二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为 “独生节点” 。二叉树的根节点不会是独生节点，因为它没有父节点。
         * 给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。数组的顺序 不限 。
         * 输入：root = [1,2,3,null,4] 输出：[4]
         * 解释：浅蓝色的节点是唯一的独生节点。   节点 1 是根节点，不是独生的。    节点 2 和 3 有共同的父节点，所以它们都不是独生的。
         * @param root
         * @return
         */
        public List<Integer> getLonelyNodes(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            getLonelyNodes(root, res);
            return res;
        }
        public void getLonelyNodes(TreeNode root, List<Integer> res) {
            if(root == null || (root.left == null && root.right == null)){
                return;
            }else if(root.left == null && root.right != null){
                res.add(root.right.val);
                getLonelyNodes(root.right, res);
            }else if(root.left != null && root.right == null){
                res.add(root.left.val);
                getLonelyNodes(root.left, res);
            }else{
                getLonelyNodes(root.right, res);
                getLonelyNodes(root.left, res);
            }
        }

        /**
         * 剑指 Offer 68 - II. 二叉树的最近公共祖先
         * 236. 二叉树的最近公共祖先
         * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
         * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
         * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
         * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1       输出: 3       解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
         * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4       输出: 5       解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
         * 1.所有节点的值都是唯一的。2.p、q 为不同节点且均存在于给定的二叉树中。
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            // 核心算法：分别去左右子树中查找是否有公共点
            if(root == null || root == p || root == q){
                return root;
            }
            TreeNode left = lowestCommonAncestor1(root.left, p, q);
            TreeNode right = lowestCommonAncestor1(root.right, p, q);
            if(left == null && right == null){
                return null;
            }else if(left == null){
                return right;
            }else if(right == null){
                return left;
            }else{
                return root;
            }
        }


    }

    /**
     * 回溯算法
     */
    static class Recall{

        public static void main(String[] args) {
            TreeNode a = new TreeNode(1);
            TreeNode b = new TreeNode(2);
            TreeNode c = new TreeNode(3);
            TreeNode d = new TreeNode(5);
            a.left = b;
            a.right = c;
            b.right = d;
            System.out.println(binaryTreePaths(a));
        }

        /**
         * 257. 二叉树的所有路径
         * 回溯算法
         * 给定一个二叉树，返回所有从根节点到叶子节点的路径。说明: 叶子节点是指没有子节点的节点。
         * 输入:                       输出: ["1->2->5", "1->3"]
         *    1
         *   / \
         *  2   3
         *   \
         *    5
         * @param root
         * @return
         */
        public static List<String> binaryTreePaths(TreeNode root) {
            List<String> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            binaryTreePaths(root, ans, new StringBuilder());
            return ans;
        }
        public static void binaryTreePaths(TreeNode root, List<String> res, StringBuilder sb) {
            if(root.left == null && root.right == null){
                sb.append(root.val);
                res.add(sb.toString());
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
        }

        /**
         * 113. 路径总和 II
         * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。说明: 叶子节点是指没有子节点的节点。
         * 示例:给定如下二叉树，以及目标和 sum = 22，
         *       5
         *      / \
         *     4   8
         *    /   / \
         *   11  13  4
         *  /  \    / \
         * 7    2  5   1
         * [[5,4,11,2],[5,8,4,5]]
         * @param root
         * @param sum
         */
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            hasPathSum(root, sum, res, new ArrayList<>());
            return res;
        }

        public void hasPathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
            if(root == null) return;
            if(root.left == null && root.right == null){
                if(root.val == sum) {
                    temp.add(root.val);
                    res.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                }
                return;
            }
            temp.add(root.val);
            hasPathSum(root.left, sum - root.val, res, temp);
            hasPathSum(root.right, sum - root.val, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        List<TreeNode> children;
        TreeNode(){}
        TreeNode(int val){
            this(val, null, null, null);
        }
        TreeNode(int val, TreeNode left, TreeNode right, List<TreeNode> children) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.children = children;
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

}




