package com.techendear.linkedlist;

public class MergeLinkedListSorted {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(7);
        Node<Integer> c = new Node<>(10);
        Node<Integer> d = new Node<>(12);
        Node<Integer> e = new Node<>(20);
        Node<Integer> f = new Node<>(28);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // 5 -> 7 -> 10 -> 12 -> 20 -> 28

        Node<Integer> q = new Node<>(6);
        Node<Integer> r = new Node<>(8);
        Node<Integer> s = new Node<>(9);
        Node<Integer> t = new Node<>(25);
        q.next = r;
        r.next = s;
        s.next = t;
        // 6 -> 8 -> 9 -> 25
        Node<Integer> res = mergeSorted(a, q);
        while (res != null) {
            if (res.next == null)
                System.out.print(res.val);
            else
                System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println();
    }

    private static Node<Integer> mergeSorted(Node<Integer> ll1, Node<Integer> ll2) {
        Node<Integer> head = new Node<>(0);
        Node<Integer> tail = head;
        while (ll1 != null && ll2 != null) {
            if (ll1.val >= ll2.val) {
                tail.next = ll2;
                ll2 = ll2.next;
            } else {
                tail.next = ll1;
                ll1 = ll1.next;
            }
            tail = tail.next;
        }
        if (ll1 != null) tail.next = ll1;
        if (ll2 != null) tail.next = ll2;
        return head.next;
    }

}
