package com.techendear.array.oned;

import java.util.HashMap;
import java.util.Map;

public class SetRowColZero {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 0, 3, 4}, {0,3, 4, 5, 7}, {1, 3, 4, 5, 6}, {4, 5, 6, 7, 8}, {8, 7, 6, 5, 0}};
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    map.put(i, j);
                }
            }
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            zeroMat(mat, e.getKey(), e.getValue());
        }
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static void zeroMat(int[][] mat, int i, int j) {
        if (mat[i][j] == 0) {
            for (int k = 0; k < mat.length; k++) {
                mat[i][k] = 0;
            }
            for (int k = 0; k < mat[0].length; k++) {
                mat[k][j] = 0;
            }
        }
    }
}
