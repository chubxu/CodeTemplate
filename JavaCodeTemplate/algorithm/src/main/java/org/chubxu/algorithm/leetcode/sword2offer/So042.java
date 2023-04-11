package org.chubxu.algorithm.leetcode.sword2offer;

public class So042 {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (res <= 0) {
                res = num;
            } else {
                res += num;
            }
            max = Math.max(res, max);
        }
        return max;
    }
}
