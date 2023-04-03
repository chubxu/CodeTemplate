package org.chubxu.algorithm.leetcode.sword2offer;

import java.util.Arrays;

public class So061 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            if (nums[i] == nums[i+1]) return false;
        }
        return nums[4] - nums[count] < 5;
    }
}
