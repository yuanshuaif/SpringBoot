package com.lsj.springboot.Util.BinarySortTree;

/**
 * Created by 10326 on 2020/3/15.
 */
public class OperateBinarySortTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // 1.二叉树的插入操作
    public void insertBST(int value){
        Node corrent = root;
        // 循环查找需要插入的节点
        Node prev = null;
        while(corrent != null){
            prev = corrent;
            if(corrent.getValue() == value){// 值相等的时候不需要任何操作
                break;
            }else if(corrent.getValue() < value){
                corrent = corrent.getRight();
            }else if(corrent.getValue() > value){
                corrent = corrent.getLeft();
            }
        }
        // prev 是待插入的节点
        if(root == null){
            root = new Node(value);
        }else if(value < prev.getValue()){
            Node left = new Node(value);
            prev.setLeft(left);
            left.setParent(prev);
        }else if(value > prev.getValue()){
            Node right = new Node(value);
            prev.setRight(right);
            right.setParent(prev);
        }
    }

    // 2.二叉树的查找操作
    public boolean searchBST(int key){
        Node corrent = root;
        while(corrent != null){
            if(corrent.getValue() == key){
                return true;
            }else if(corrent.getValue() > key){
                corrent = corrent.getLeft();
            }else if(corrent.getValue() < key){
                corrent =corrent.getRight();
            }
        }
        return false;
    }

    // 3.二叉树的删除操作
    public boolean deleteBST(int key){
        return deleteBST(root, key);
    }

    public boolean deleteBST(Node node, int key){
        if(node == null)
            return false;
        else{
            if(key == node.getValue()){
                return delete(node);
            }if(key < node.getValue()){
                return deleteBST(node.getLeft(), key);
            }else {
                return deleteBST(node.getRight(), key);
            }
        }
    }
    public boolean delete(Node node){
        Node parent = null;
        if(node.getLeft() == null){
            if(node.getParent() == null){
                root = node.getRight();
            }else if(node.getParent().getLeft() == node){
                node.getParent().setLeft(node.getRight());
            }else if(node.getParent().getRight() == node){
                node.getParent().setRight(node.getRight());
            }
//            node = node.getRight();// 如果左子节点为空，右子节点作为当前节点（node指向新对象，但是父节点依然指向原来的对象）？？？？ 不生效
        }else if(node.getRight() == null){
            if(node.getParent() == null){
                root = node.getLeft();
            }else if(node.getParent().getLeft() == node){
                node.getParent().setLeft(node.getLeft());
            }else if(node.getParent().getRight() == node){
                node.getParent().setRight(node.getLeft());
            }
//            node = node.getLeft();// 如果右子节点为空，左子节点作为当前节点
        }else{// 左右节点均不为空
            parent = node;
            Node corrent = node.getLeft();// 转向左子树，取最大值
            while (corrent.getRight() != null){
                parent = corrent;
                corrent = corrent.getRight();
            }
            node.setValue(corrent.getValue());
            if(parent == node){// 左子树中没有右子树，整体上移
                parent.setLeft(corrent.getLeft());
            }else{// 左子树中有右子树，单个上移，上移节点的左节点为其父节点的右节点
                parent.setRight(corrent.getLeft());
            }
        }
        return true;
    }
    public static void main(String[] args){
        OperateBinarySortTree tree = new OperateBinarySortTree();
        tree.insertBST(8);
        tree.insertBST(12);
        tree.insertBST(7);
        tree.insertBST(9);
        tree.insertBST(10);
        tree.insertBST(18);
        tree.insertBST(6);
        tree.insertBST(5);
        tree.insertBST(17);
        tree.insertBST(20);
        System.out.println(tree.searchBST(7));
        tree.deleteBST(8);
        System.out.println(tree.getRoot());

    }
}
