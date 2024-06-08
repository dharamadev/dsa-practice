package com.techendear.tree;

public class CountLeafNodes {
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
        printLeaf(a);
    }

    private static void printLeaf(Node<String> root) {
        if(root==null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            return;
        }

        printLeaf(root.left);
        printLeaf(root.right);
    }
}
