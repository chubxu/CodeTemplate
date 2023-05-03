package org.chubxu.algorithm.leetcode.qn006;

public class Lt643 {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0;
        double cur = 0;
        for (int i = 0; i < k; i++) {
            cur += nums[i];
        }
        res = cur / k;
        int l = 0, r = k;
        while (r < nums.length) {
            cur += nums[r++];
            cur -= nums[l++];
            res = Math.max(res, cur / k);
        }
        return res;
    }
}
