package org.chubxu.algorithm.leetcode.qn000;

public class Lt011 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int res = -1;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
