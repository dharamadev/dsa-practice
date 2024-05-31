package com.techendear.graph.undirected;

import java.util.List;
import java.util.Map;

public class DfsCountIsland {
    public static void main(String[] args) {
        List<List<String>> grid0 = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        ); // -> 3

        System.out.println("Island in grid:: " + island(grid0));
        List<List<String>> grid1 = List.of(
                List.of("L", "W", "W", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("W", "L", "W", "L", "W"),
                List.of("W", "W", "W", "W", "W"),
                List.of("W", "W", "L", "L", "L")
        ); // -> 4
        System.out.println("Island in grid:: " + island(grid1));
    }

    private static int island(List<List<String>> grid) {
        int l = grid.size();
        int m = grid.get(0).size();
        int[][] vis = new int[l][m];
        int count = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j).equals("L") && vis[i][j] != 1) {
                    count++;
                    dfs(grid, vis, l, m, i, j);
                }
            }
        }

        return count;
    }

    private static boolean isSafe(int l, int m, int i, int j) {
        return i >= 0 && i < l && j >= 0 && j < m;
    }

    private static void dfs(List<List<String>> grid, int[][] vis, int l, int m, int i, int j) {
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        vis[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int newI = i + move[k][0];
            int newJ = j + move[k][1];
            if (isSafe(l, m, newI, newJ) && vis[newI][newJ] != 1 && grid.get(newI).get(newJ).equals("L")) {
                dfs(grid, vis, l, m, newI, newJ);
            }
        }
    }
}
