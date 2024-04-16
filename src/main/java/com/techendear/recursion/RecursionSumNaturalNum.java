package com.techendear.recursion;

public class RecursionSumNaturalNum {
    public static void main(String[] args) {
        System.out.println(sum(3));
    }

    private static int sum(int num) {
        if (num == 0) return 0;
        return num += sum(num - 1);
    }
}
