package org.chubxu.algorithm.leetcode.sword2offer;

public class So057 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
