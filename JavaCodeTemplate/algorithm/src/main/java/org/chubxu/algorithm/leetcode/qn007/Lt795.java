package org.chubxu.algorithm.leetcode.qn007;

import org.junit.Test;

public class Lt795 {
    @Test
    public void test() {
        int[] nums = new int[]{2,1,4,3};
        numSubarrayBoundedMax(nums, 2, 3);
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int r = -1, l = -1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                r = i;
            } else if (nums[i] > right) {
                l = i;
                r = -1;
            }
            if (r != -1) {
                res += r-l;
            }
        }
        return res;
    }

}
