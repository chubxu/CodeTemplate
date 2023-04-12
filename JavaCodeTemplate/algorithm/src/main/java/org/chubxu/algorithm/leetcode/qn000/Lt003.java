package org.chubxu.algorithm.leetcode.qn000;

import java.util.HashMap;
import java.util.Map;

public class Lt003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> bucket = new HashMap<>();
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        int max = Integer.MIN_VALUE;
        while (r < chars.length) {
            if (bucket.containsKey(chars[r])) {
                l = Math.max(bucket.get(chars[r])+1, l);
            }
            bucket.put(chars[r], r);
            max = Math.max(r-l+1, max);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Lt003 l = new Lt003();
        String str = "abba";
        System.out.println(l.lengthOfLongestSubstring(str));
    }
}
