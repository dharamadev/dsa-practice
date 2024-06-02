package com.techendear.linkedlist;

public class ReverseListRecursive {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(10);
        Node<Integer> d = new Node<>(12);
        Node<Integer> e = new Node<>(20);
        Node<Integer> f = new Node<>(25);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(a);
        System.out.println(reverseList(a));
    }

    private static Node<Integer> reverseList(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> tmp = reverseList(head.next);
        System.out.println(tmp);
        return head;
    }
}
