package com.techendear.graph.undirected;

import java.util.*;

public class PathToCarrot {

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X", "X", "X"),
                List.of("O", "X", "X", "X", "C"),
                List.of("O", "X", "O", "X", "X"),
                List.of("O", "O", "O", "O", "O"),
                List.of("O", "X", "X", "X", "X"),
                List.of("O", "O", "O", "O", "O"),
                List.of("O", "O", "C", "O", "O"),
                List.of("O", "O", "O", "O", "O")
        );

        System.out.println("Carrot::: " + closestCarrot(grid, 3, 4));
    }

    public static int closestCarrot(List<List<String>> grid, int startRow, int startCol) {
        // todo
        Set<List<Integer>> vis = new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(startRow, startCol, 0));
        vis.add(List.of(startRow, startCol));
        while (!q.isEmpty()) {
            List<Integer> val = q.remove();
            int r = val.get(0);
            int c = val.get(1);
            int dist = val.get(2);
            if (grid.get(r).get(c) == "C") return dist;
            List<List<Integer>> deltas = List.of(
                    List.of(1, 0),
                    List.of(-1, 0),
                    List.of(0, 1),
                    List.of(0, -1)
            );

            for (List<Integer> delta : deltas) {
                int deltaRow = delta.get(0);
                int deltaCol = delta.get(1);
                int newRow = r + deltaRow;
                int newCol = c + deltaCol;
                List<Integer> key = List.of(newRow, newCol);
                if (safe(newRow, newCol, grid.size(), grid.get(0).size()) && !vis.contains(key) && !grid.get(newRow).get(newCol).equals("X")) {
                    vis.add(key);
                    q.add(List.of(newRow, newCol, dist + 1));
                }
            }
        }
        return -1;
    }


    private static boolean safe(int i, int j, int l, int m) {
        return i >= 0 && i < l && j >= 0 && j < m;
    }
}
