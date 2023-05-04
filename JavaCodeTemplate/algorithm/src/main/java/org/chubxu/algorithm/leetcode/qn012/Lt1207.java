package org.chubxu.algorithm.leetcode.qn012;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lt1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> count = new HashSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (count.contains(integerIntegerEntry.getValue())) return false;
            count.add(integerIntegerEntry.getValue());
        }
        return true;
    }
}
