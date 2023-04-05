package org.chubxu.algorithm.leetcode.sword2offer;

public class So021 {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            while ((nums[l] & 2) == 1) l++;
            while ((nums[r] & 2) == 0) r--;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}
