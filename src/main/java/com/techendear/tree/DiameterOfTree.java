package com.techendear.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTree {
    public static void main(String[] args) {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;


        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f
        //    /
        //   g
        System.out.println("Dim:: " + getDim(a));
    }

    private static int getDim(Node<String> root) {
        if (root == null) return 0;
        AtomicInteger a = new AtomicInteger(0);
        height(root, a);
        return a.get();
    }

    private static int height(Node<String> root, AtomicInteger a) {
        if (root == null) return 0;
        int left = height(root.left, a);
        int right = height(root.right, a);
        a.set(Math.max(a.get(), (1 + left + right)));
        return 1 + Math.max(left, right);
    }
}
