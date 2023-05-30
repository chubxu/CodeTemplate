package org.chubxu.algorithm.leetcode.qn026;

import java.util.HashMap;
import java.util.HashSet;

public class Lt2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        var set = new HashSet<>();
        var suf = new int[nums.length+1];
        for (int i = nums.length-1; i > 0; i--) {
            set.add(nums[i]);
            suf[i] = set.size();
        }

        set.clear();
        var res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            res[i] = set.size() - suf[i+1];
        }
        return res;
    }
}
