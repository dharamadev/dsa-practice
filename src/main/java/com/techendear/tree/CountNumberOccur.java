package com.techendear.tree;

import java.util.Objects;
import java.util.Stack;

public class CountNumberOccur {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(12);
        Node<Integer> b = new Node<>(6);
        Node<Integer> c = new Node<>(6);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(6);
        Node<Integer> f = new Node<>(12);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      12
        //    /   \
        //   6     6
        //  / \     \
        // 4   6     12

        System.out.println("Count occurrence :: " + countOccur(a, 6));
        System.out.println("Count occurrence recursive :: " + countOccurItr(a, 6));

    }

    private static int countOccur(Node<Integer> root, Integer target) {
        if (root == null) return 0;
        int val = Objects.equals(root.val, target) ? 1 : 0;
        return val + countOccur(root.left, target) + countOccur(root.right, target);
    }

    private static int countOccurItr(Node<Integer> root, Integer target) {
        if (root == null) return 0;
        Stack<Node<Integer>> st = new Stack<>();
        st.add(root);
        int count = 0;
        while (!st.isEmpty()) {
            Node<Integer> curr = st.pop();
            if (Objects.equals(curr.val, target)) count++;
            if (curr.left != null)
                st.add(curr.left);
            if (curr.right != null)
                st.add(curr.right);
        }
        return count;
    }
}
