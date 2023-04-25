package org.chubxu.algorithm.leetcode.qn003;

public class Lt334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int f = nums[0], s = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > s) return true;
            if (nums[i] > f) s = nums[i];
            if (nums[i] < f) f = nums[i];
        }
        return false;
    }
}
