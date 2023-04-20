package org.chubxu.algorithm.leetcode.qn000;

public class Lt031 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        if (i >= 0) {
            int j = len-1;
            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    public void reverse(int[] nums, int l) {
        int r = nums.length-1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
