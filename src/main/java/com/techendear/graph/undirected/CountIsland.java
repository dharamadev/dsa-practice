package com.techendear.graph.undirected;

import java.util.List;

public class CountIsland {
    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );
        System.out.println(minimumIsland(grid));
    }

    public static int minimumIsland(List<List<String>> grid) {
        // todo
        int n = grid.size();
        int m = grid.get(0).size();
        int count = Integer.MAX_VALUE;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j).equals("L") && vis[i][j] != 1) {
                    count = Math.min(count, size(grid, i, j, n, m, vis));
                }
            }
        }
        return count;
    }

    private static boolean safe(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private static int size(List<List<String>> grid, int i, int j, int n, int m, int[][] vis) {
        if (grid.get(i).get(j).equals("W")) return 0;
        int count = 1;
        vis[i][j] = 1;
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int newi = i + move[k][0];
            int newj = j + move[k][1];
            if (safe(newi, newj, n, m) && grid.get(newi).get(newj).equals("L") && vis[newi][newj] != 1) {
                count += size(grid, newi, newj, n, m, vis);
                vis[newi][newj] = 1;
            }
        }
        return count;
    }
}
