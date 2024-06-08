package com.techendear.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParentOfNode {
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
        System.out.println("List:: " + getParents(a, "e"));
    }

    private static List<String> getParents(Node<String> root, String node) {
        if (root == null) return null;
        if (Objects.equals(root.val, node)) {
            List<String> l = new ArrayList<>();
            l.add(root.val);
            return l;
        }

        List<String> left = getParents(root.left, node);
        if (left != null) {
            left.add(root.val);
            return left;
        }

        List<String> right = getParents(root.right, node);
        if (right != null) {
            right.add(root.val);
            return right;
        }

        return null;
    }
}
