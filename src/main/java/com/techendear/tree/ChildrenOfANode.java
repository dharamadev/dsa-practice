package com.techendear.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChildrenOfANode {
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
        System.out.println(child(a, "b", new ArrayList<>()));
    }

    private static List<String> child(Node<String> root, String val, List<String> res) {
        if(root == null) return null;
        if(Objects.equals(root.val, val)) {
            res.add(root.val);
        }
        List<String> l = child(root.left, val, res);
        if(l!=null)
            res.add(root.val);
        List<String> r = child(root.right, val, res);
        if(r!=null)
            res.add(root.val);
        return res;
    }
}
