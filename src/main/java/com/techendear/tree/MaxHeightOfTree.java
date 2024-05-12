package com.techendear.tree;

import java.util.Stack;

public class MaxHeightOfTree {
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

        System.out.println("Max height::: " + heightTree(a));
    }

    private static int heightTree(Node<String> root) {
        if (root == null) return 0;
        return 1 + Math.max(heightTree(root.left), heightTree(root.right));
    }
}
