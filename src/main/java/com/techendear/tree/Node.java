package com.techendear.tree;

public class Node<T> {
    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
