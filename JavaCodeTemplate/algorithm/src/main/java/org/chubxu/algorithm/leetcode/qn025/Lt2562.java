package org.chubxu.algorithm.leetcode.qn025;

public class Lt2562 {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int l = 0, r = nums.length-1;
        while (l <= r) {
            if (l == r) {
                res += nums[l];
                return res;
            }
            StringBuilder concValStr = new StringBuilder();
            res += Integer.parseInt(concValStr.append(nums[l]).append(nums[r]).toString());

            l++;
            r--;
        }
        return res;
    }
}
