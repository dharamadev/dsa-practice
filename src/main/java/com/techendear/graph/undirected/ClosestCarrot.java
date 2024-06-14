package com.techendear.graph.undirected;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class ClosestCarrot {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "O", "O", "O"),
                List.of("O", "X", "O", "O", "O"),
                List.of("O", "X", "X", "O", "O"),
                List.of("O", "X", "C", "O", "O"),
                List.of("O", "X", "X", "O", "O"),
                List.of("C", "O", "O", "O", "O")
        );
        System.out.println(closestCarrot(grid, 1, 2));
    }

    public static int closestCarrot(List<List<String>> grid, int startRow, int startCol) {
        // todo
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] vis = new int[n][m];
        return length(grid, startRow, startCol, n, m);
    }

    private static boolean safe(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private static int length(List<List<String>> grid, int i, int j, int n, int m) {
        Queue<List<Integer>> qu = new LinkedList<>();
        qu.add(List.of(i, j, 0));
        Set<SimpleEntry<Integer, Integer>> vis = new HashSet<>();
        vis.add(new SimpleEntry<>(i, j));
        while (!qu.isEmpty()) {
            List<Integer> curr = qu.poll();
            Integer r = curr.get(0);
            Integer c = curr.get(1);
            Integer dist = curr.get(2);
            int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            if (grid.get(r).get(c).equals("C")) return dist;
            for (int k = 0; k < 4; k++) {
                int newi = r + move[k][0];
                int newj = c + move[k][1];
                if (safe(newi, newj, n, m) && !grid.get(newi).get(newj).equals("X") && !vis.contains(new SimpleEntry<>(newi, newj))) {
                    qu.add(List.of(newi, newj, dist + 1));
                    vis.add(new SimpleEntry<>(newi, newj));
                }
            }
        }
        return -1;
    }
}
