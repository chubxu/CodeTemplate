package org.chubxu.algorithm.leetcode.lcp;

import java.util.Arrays;

public class Lcp028 {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1, res = 0;
        while (l < r) {
            if (nums[l] + nums[r] <= target) {
                res += r - l;
                res %= 1000000007;
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
