package com.techendear.math.numbers;

public class CountDigits {
    public static void main(String[] args) {
        System.out.println(count(10000));
        System.out.println(count(100000000));
    }

    private static Integer count(Integer num) {
        if (num == 0) return 1;
        Integer result = 0;
        while (num > 0) {
            num = num / 10;
            result++;
        }
        return result;
    }
}
