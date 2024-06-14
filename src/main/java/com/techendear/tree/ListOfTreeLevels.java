package com.techendear.tree;

import java.util.*;

public class ListOfTreeLevels {
    public static void main(String[] args) {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");
        Node<String> i = new Node<>("i");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        e.right = h;
        f.left = i;

        //         a
        //      /    \
        //     b      c
        //   /  \      \
        //  d    e      f
        //      / \    /
        //     g  h   i
        System.out.println(getLevelList(a));
    }

    private static List<List<String>> getLevelList(Node<String> root) {
        Queue<AbstractMap.SimpleEntry<Node<String>, Integer>> q = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<Node<String>, Integer> entry = q.poll();
            Node<String> node = entry.getKey();
            Integer level = entry.getValue();

            if (level == res.size()) {
                List<String> val = new ArrayList<>();
                val.add(node.val);
                res.add(val);
            } else {
                res.get(level).add(node.val);
            }

            if (node.left != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.left, level + 1));
            }

            if (node.right != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.right, level + 1));
            }
        }
        return res;
    }
}
