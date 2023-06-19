package org.chubxu.algorithm.leetcode.qn024;

import java.util.HashSet;
import java.util.Set;

public class Lt2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = -1;
        for (int num : nums) {
            if (set.contains(-num)) {
                res = Math.max(res, Math.abs(num));
            }
            set.add(num);
        }
        return res;
    }
}
