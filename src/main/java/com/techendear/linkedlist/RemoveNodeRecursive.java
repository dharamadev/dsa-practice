package com.techendear.linkedlist;

public class RemoveNodeRecursive {

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(5);
        Node<Integer> d = new Node<>(12);
        Node<Integer> e = new Node<>(20);
        Node<Integer> f = new Node<>(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(a);

        Node<Integer> r = remNode(a, 5);
        System.out.println(r);
    }

    private static Node<Integer> remNode(Node<Integer> head, int val) {
        if (head == null) return null;
        head.next = remNode(head.next, val);
        return head.val == val ? head.next : head;
    }
}
