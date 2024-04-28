package com.techendear.linkedlist;

import java.util.Objects;

public class LongestStreak {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(5);
        Node<Integer> c = new Node<>(5);
        Node<Integer> d = new Node<>(5);
        Node<Integer> e = new Node<>(7);
        Node<Integer> f = new Node<>(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println("Longest Streak::: "+longestStreak(a));
    }

    private static int longestStreak(Node<Integer> head) {
        int count = 0;
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        int maxCount = 0;
        while (fast != null) {
            if(Objects.equals(slow.val, fast.val)) {
                count++;
            } else {
                slow = fast;
                count = 1;
            }
            if(maxCount< count) maxCount = count;
            fast = fast.next;
        }
        return maxCount;
    }
}
