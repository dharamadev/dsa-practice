package com.techendear.tree;

public class NumberOfLevels {
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
        System.out.println("level count:: " + getLevels(a));
    }

    private static int getLevels(Node<String> root) {
        if (root == null) return 0;
        return 1 + Math.max(getLevels(root.left), getLevels(root.right));
    }
}
