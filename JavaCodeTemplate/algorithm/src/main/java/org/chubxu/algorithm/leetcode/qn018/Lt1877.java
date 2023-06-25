package org.chubxu.algorithm.leetcode.qn018;

import java.util.Arrays;

public class Lt1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[n - 1];
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            ans = Math.max(ans, nums[i] + nums[j]);
        }
        return ans;
    }
}
