package com.techendear.recursion;

public class RecursionBeforeAfter {
    public static void main(String[] args) {
        beforeAfter(10);
    }

    private static void beforeAfter(int num) {
        if (num == 0) return;
        System.out.println("Before::" + num);
        beforeAfter(num - 1);
        System.out.println("After::" + num);
    }
}
