package com.techendear.tree;

import java.util.*;
import java.util.stream.Collectors;

public class LevelAverageTree {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(5);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(54);
        Node<Integer> d = new Node<>(20);
        Node<Integer> e = new Node<>(15);
        Node<Integer> f = new Node<>(1);
        Node<Integer> g = new Node<>(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

        //        5
        //     /    \
        //    11    54
        //  /   \
        // 20   15
        //      / \
        //     1  3

        System.out.println(levelAvgTree(a));
        System.out.println(treeLvlAvg(a));
    }

    private static List<Double> levelAvgTree(Node<Integer> root) {
        Map<Integer, AbstractMap.SimpleEntry<Integer, Integer>> m = new HashMap<>();
        Queue<AbstractMap.SimpleEntry<Node<Integer>, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));
        List<Double> result = new ArrayList<>();
        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<Node<Integer>, Integer> entry = q.poll();
            Node<Integer> node = entry.getKey();
            Integer level = entry.getValue();

            if (m.containsKey(level)) {
                AbstractMap.SimpleEntry<Integer, Integer> e = m.get(level);
                AbstractMap.SimpleEntry<Integer, Integer> newEntry = new AbstractMap.SimpleEntry<>(e.getKey() + node.val, e.getValue() + 1);
                m.put(level, newEntry);
            } else {
                m.put(level, new AbstractMap.SimpleEntry<>(node.val, 1));
            }
            if (node.left != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.left, level + 1));
            }
            if (node.right != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.right, level + 1));
            }
        }
        m.forEach((k, v) -> {
            Double val = (double) v.getKey() / v.getValue();
            result.add(k, val);
        });
        return result;
    }

    private static List<Double> treeLvlAvg(Node<Integer> root) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> lst = new ArrayList<>();
        Queue<AbstractMap.SimpleEntry<Node<Integer>, Integer>> q = new LinkedList<>();
        q.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<Node<Integer>, Integer> entry = q.poll();
            Node<Integer> node = entry.getKey();
            Integer level = entry.getValue();

            if (level < lst.size()) {
                AbstractMap.SimpleEntry<Integer, Integer> e = lst.get(level);
                AbstractMap.SimpleEntry<Integer, Integer> newEntry = new AbstractMap.SimpleEntry<>(e.getKey() + node.val, e.getValue() + 1);
                lst.set(level, newEntry);
            } else {
                lst.add(new AbstractMap.SimpleEntry<>(node.val, 1));
            }

            if (node.left != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.left, level + 1));
            }
            if (node.right != null) {
                q.add(new AbstractMap.SimpleEntry<>(node.right, level + 1));
            }
        }
        return lst.stream().map(v -> {
            return (double) v.getKey() / v.getValue();
        }).collect(Collectors.toList());
    }
}
