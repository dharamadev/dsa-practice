package com.techendear.linkedlist;

public class AddLinkedList {
    public static void main(String[] args) {
        Node<Integer> a1 = new Node<>(9);
        Node<Integer> a2 = new Node<>(6);
        a1.next = a2;

        Node<Integer> b1 = new Node<>(7);
        Node<Integer> b2 = new Node<>(6);
        Node<Integer> b3 = new Node<>(5);
        b1.next = b2;
        b2.next = b3;

        System.out.println("Sum of:: ll1= " + a1 + " and ll2= " + b1);

        System.out.println(addList(a1, b1));
    }

    private static Node<Integer> addList(Node<Integer> ll1, Node<Integer> ll2) {
        Node<Integer> curr1 = ll1;
        Node<Integer> curr2 = ll2;
        Node<Integer> resHead = new Node<>(0);
        Node<Integer> res = resHead;
        int carry = 0;
        while (curr1 != null && curr2 != null) {
            int val = (curr1.val + curr2.val + carry) % 10;
            carry = (curr1.val + curr2.val + carry) / 10;
            res.next = new Node<>(val);
            res = res.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if (curr1 != null) {
            while (curr1 != null) {
                int val = (curr1.val + carry) % 10;
                carry = (curr1.val + carry) / 10;
                res.next = new Node<>(val);
                res = res.next;
                curr1 = curr1.next;
            }
        }

        if (curr2 != null) {
            while (curr2 != null) {
                int val = (curr2.val + carry) % 10;
                carry = (curr2.val + carry) / 10;
                res.next = new Node<>(val);
                curr2 = curr2.next;
            }
        }

        if (carry > 0) {
            while (carry != 0) {
                res.next = new Node<>(carry % 10);
                carry /= 10;
                res = res.next;
            }
        }

        return resHead.next;
    }
}
