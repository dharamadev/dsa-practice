package com.techendear.tree;

import java.util.*;

public class PathTillNode {
    public static void main(String[] args) {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        System.out.println("Path till target valur 'e'::: " + pathTillNode(a, "e"));
        List<String> res = pathTillNodeSec(a, "e");
        Collections.reverse(res);
        System.out.println("Path till target valur 'e'::: " + res);
    }

    private static List<String> pathTillNode(Node<String> root, String target) {
        if (root == null) return null;
        if (Objects.equals(root.val, target)) return List.of(root.val);

        List<String> leftTree = pathTillNode(root.left, target);
        if (leftTree != null) {
            List<String> path = new ArrayList<>();
            path.add(root.val);
            path.addAll(leftTree);
            return path;
        }

        List<String> rightTree = pathTillNode(root.right, target);
        if (rightTree != null) {
            List<String> path = new ArrayList<>();
            path.add(root.val);
            path.addAll(rightTree);
            return path;
        }
        return null;
    }

    private static List<String> pathTillNodeSec(Node<String> root, String target) {
        if (root == null) return null;
        if (Objects.equals(root.val, target)) {
            List<String> path = new ArrayList<>();
            path.add(root.val);
            return path;
        }

        List<String> leftTree = pathTillNodeSec(root.left, target);
        if (leftTree != null) {
            leftTree.add(root.val);
            return leftTree;
        }

        List<String> rightTree = pathTillNodeSec(root.right, target);
        if (rightTree != null) {
            rightTree.add(root.val);
            return rightTree;
        }
        return null;
    }
}
