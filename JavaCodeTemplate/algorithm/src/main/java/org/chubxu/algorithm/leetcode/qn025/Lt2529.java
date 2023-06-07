package org.chubxu.algorithm.leetcode.qn025;

public class Lt2529 {
    public int maximumCount(int[] nums) {
        int a = 0, n = 0;
        for (int num : nums) {
            if (num > 0) a++;
            if (num < 0) n++;
        }
        return Math.max(a, n);
    }

    public int maximumCount2(int[] nums) {
        int n = bs(nums, 0, nums.length, 0);
        int a = bs(nums, n, nums.length, 1);
        return Math.max(n, (nums.length-a));
    }

    public int bs(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (target <= nums[mid])
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }
}
