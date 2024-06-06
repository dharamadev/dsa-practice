package com.techendear.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
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

        System.out.println("===Preorder===");
        preOrder(a);
        System.out.println("===Inorder===");
        inOrder(a);
        System.out.println("===Postorder===");
        postOrder(a);
        System.out.println("===Level Order===");
        levelOrder(a);
    }

    private static void preOrder(Node<String> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(Node<String> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    private static void postOrder(Node<String> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    private static void levelOrder(Node<String> root) {
        if(root==null) return;
        Queue<Node<String>> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node<String> curr = q.poll();
            System.out.println(curr.val);
            if(curr.left != null) {
                q.add(curr.left);
            }

            if(curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}
