package org.chubxu.algorithm.leetcode.sword2offer;

public class So039 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int cur = nums[0];
        for (int num : nums) {
            if (vote == 0) {
                cur = num;
            }
            if (cur == num) {
                vote++;
            } else {
                vote--;
            }
        }
        return cur;
    }
}
