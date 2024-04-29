package com.techendear.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalDFS {

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

        System.out.println("DFS::: " + dfs(a));
    }

    private static List<String> dfs(Node<String> root) {
        Stack<Node<String>> val = new Stack<>();
        List<String> res = new ArrayList<>();
        val.add(root);

        while (!val.isEmpty()) {
            Node<String> curr = val.pop();
            res.add(curr.val);

            if (curr.right != null)
                val.add(curr.right);

            if (curr.left != null)
                val.add(curr.left);
        }
        return res;
    }

}
