package com.techendear.linkedlist;

public class AddNumLL {
    public static void main(String[] args) {
        Node<Integer> a1 = new Node<>(5);
        Node<Integer> b1 = new Node<>(5);
        Node<Integer> c1 = new Node<>(5);
        Node<Integer> d1 = new Node<>(5);
        Node<Integer> e1 = new Node<>(7);
        Node<Integer> f1 = new Node<>(7);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = f1;


        Node<Integer> a2 = new Node<>(5);
        Node<Integer> b2 = new Node<>(5);
        Node<Integer> c2 = new Node<>(5);
        Node<Integer> d2 = new Node<>(5);
        Node<Integer> e2 = new Node<>(7);
        Node<Integer> f2 = new Node<>(7);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        e2.next = f2;

        Node<Integer> v = sum(a1, a2);
        System.out.println(v.val);
    }

    private static Node<Integer> sum(Node<Integer> l1, Node<Integer> l2) {
        int carry = 0;
        Node<Integer> sum = new Node<>(0);
        Node<Integer> tail = sum;
        while (l1 != null && l2 != null) {
            int s = (carry + l1.val + l2.val);
            tail.next = new Node<>(s % 10);
            carry = s / 10;
            System.out.println(s % 10 + "::" + (s / 10) + "::" + carry);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = l1;
            l2 = l2.next;
        }
        return tail;
    }
}
