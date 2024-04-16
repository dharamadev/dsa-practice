package com.techendear.recursion;

public class RecursionDoubleRecursion {
    public static void main(String[] args) {
        dub(3);
    }

    private static void dub(int num) {
        if (num == 0) return;
        System.out.println("Before::" + num);
        dub(num - 1);
//        System.out.println("Middle::" + num);
        dub(num - 1);
//        System.out.println("After::" + num);
    }
}
