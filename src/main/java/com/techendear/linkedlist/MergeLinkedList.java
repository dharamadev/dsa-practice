package com.techendear.linkedlist;

public class MergeLinkedList {
    public static void main(String[] args) {

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        a.next = b;
        b.next = c;
        // a -> b -> c

        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");
        Node<String> z = new Node<>("z");
        Node<String> p = new Node<>("p");
        Node<String> m = new Node<>("m");
        x.next = y;
        y.next = z;
        z.next = p;
        p.next = m;
        // x -> y -> z

        // Answer
        // a -> x -> b -> y -> c -> z
        Node<String> res = mergeList(a, x);
        while (res != null) {
            if (res.next == null)
                System.out.print(res.val);
            else
                System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println();
    }

    private static Node<String> mergeList(Node<String> ll1, Node<String> ll2) {
        Node<String> head = ll1;
        Node<String> curr1 = ll1.next;
        Node<String> curr2 = ll2;
        Node<String> tail = head;
        int count = 0;

        while (curr1 != null && curr2 != null) {
            if (count % 2 == 0) {
                tail.next = curr2;
                curr2 = curr2.next;
            } else {
                tail.next = curr1;
                curr1 = curr1.next;
            }
            count++;
            tail = tail.next;
        }
        if(curr1 != null) {
            tail.next = curr1;
        }
        if(curr2 != null) {
            tail.next = curr2;
        }
        return head;
    }
}
