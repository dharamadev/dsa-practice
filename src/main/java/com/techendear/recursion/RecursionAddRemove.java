package com.techendear.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionAddRemove {
    public static void main(String[] args) {
        List<Integer> mat = new ArrayList<>();
        addRem(mat, 10);
    }

    private static void addRem(List<Integer> mat, int num) {
        if (num == 0) return;
        System.out.println("Before::" + mat);
        mat.add(num);
        addRem(mat, num - 1);
        mat.remove(mat.size() - 1);
        System.out.println("Before::" + mat);
    }
}
