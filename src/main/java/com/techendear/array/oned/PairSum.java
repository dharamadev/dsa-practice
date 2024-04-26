package com.techendear.array.oned;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSum {
    public static void main(String[] args) {
        List<Integer> res = getsum(List.of(3, 2, 5, 4, 1), 8);
        System.out.println(res);
    }

    private static List<Integer> getsum(List<Integer> list, Integer target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(target - list.get(i))) {
                return List.of(map.get(target - list.get(i)), i);
            }
            map.put(list.get(i), i);
        }
        return null;
    }
}
