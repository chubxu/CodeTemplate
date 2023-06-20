package org.chubxu.algorithm.leetcode.qn024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lt2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        Set<Double> set = new HashSet<>();
        while (l < r) {
            double v = (nums[l] + nums[r]) * 1.0 / 2;
            set.add(v);
            l++;r--;
        }
        return set.size();
    }
}
