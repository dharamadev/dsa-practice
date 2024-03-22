package com.techendear.dp;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class FibofGivenNumber {
    public static void main(String[] args) {
        long nano = LocalTime.now().toNanoOfDay();
        System.out.println(fib(6000, new HashMap<>()));
        System.out.println("Time taken in Milliseconds::" + Duration.ofNanos(LocalTime.now().toNanoOfDay() - nano).toMillis());

        System.out.println("=========Without memoization========");
        long nano2 = LocalTime.now().toNanoOfDay();
        System.out.println(fib(30));
        System.out.println("Time taken in Milliseconds::" + Duration.ofNanos(LocalTime.now().toNanoOfDay() - nano2).toMillis());
    }

    private static BigInteger fib(Integer num, Map<Integer, BigInteger> mem) {
        if (mem.containsKey(num)) return mem.get(num);
        if (num <= 2) return BigInteger.ONE;
        mem.put(num, fib(num - 1, mem).add(fib(num - 2, mem)));
        return mem.get(num);
    }

    private static BigInteger fib(Integer num) {
        if (num <= 2) return BigInteger.ONE;
        return (fib(num - 1).add(fib(num - 2)));
    }
}
