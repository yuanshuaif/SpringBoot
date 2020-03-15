package com.lsj.springboot.Util.BinarySortTree;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 10326 on 2020/3/15.
 */
@Data
@Getter
@Setter
public class Node {

    private int value;
    private Node left;
    private Node right;
    private Node parent;

    public Node(int value, Node left, Node right, Node parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Node(int value) {
        this(value, null, null, null);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
