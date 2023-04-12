package org.chubxu.algorithm.leetcode.qn000;

import java.util.HashMap;
import java.util.Map;

public class Lt001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (bucket.containsKey(target - nums[i])) {
                return new int[] {bucket.get(target - nums[i]), i};
            }
            bucket.put(nums[i], i);
        }
        return new int[]{};
    }
}
