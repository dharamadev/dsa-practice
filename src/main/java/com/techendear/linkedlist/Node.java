package com.techendear.linkedlist;

public class Node<T> {
    public Node<T> next;
    public T val;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}
