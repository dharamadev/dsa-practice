package com.techendear.linkedlist;

public class RevereLinkedList {
    public static void main(String[] args) {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        Node<String> head1 = a;
        while (head1 != null) {
            if (head1.next == null)
                System.out.print(head1.val);
            else
                System.out.print(head1.val + "->");
            head1 = head1.next;
        }

        System.out.println();
        System.out.println("===TO===");
        Node<String> head = reverseList(a);
        while (head != null) {
            if (head.next == null)
                System.out.print(head.val);
            else
                System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    private static Node<String> reverseList(Node<String> head) {
        Node<String> prev = null;
        Node<String> curr = head;
        while (curr != null) {
            Node<String> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
