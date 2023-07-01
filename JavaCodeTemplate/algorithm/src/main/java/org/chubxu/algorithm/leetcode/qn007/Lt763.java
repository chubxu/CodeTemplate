package org.chubxu.algorithm.leetcode.qn007;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lt763 {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> bucket = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            bucket.put(chars[i], i);
        }
        List<Integer> list = new ArrayList<>();
        int start = 0, end = 0, endMax = 0;
        for (int i = 0; i < chars.length; i++) {
            endMax = Math.max(endMax, bucket.get(chars[i]));
            if (i == endMax) {
                list.add(endMax - start + 1);
                start = endMax+1;
            }
        }

        return list;
    }

    @Test
    public void test() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
