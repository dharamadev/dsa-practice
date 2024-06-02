package com.techendear.linkedlist;

import java.util.Objects;

public class Node<T> {
    public Node<T> next;
    public T val;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node<?> node = (Node<?>) object;
        return Objects.equals(next, node.next) && Objects.equals(val, node.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, val);
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}
