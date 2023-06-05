package org.chubxu.algorithm.leetcode.qn026;

public class Lt2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] nums = new int[10];
        int min1 = 10, min2 = 10;
        for (int i : nums1) {
            nums[i]++;
            min1 = Math.min(min1, i);
        }
        for (int i : nums2) {
            nums[i]++;
            min2 = Math.min(min2, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                return i;
            }
        }
        if (min1 > min2) return min2 * 10 + min1;
        else return min1 * 10 + min2;
    }
}
