package org.chubxu.algorithm.leetcode.sword2offer;

import java.util.HashMap;
import java.util.Map;

public class So003 {
    public int findRepeatNumber2(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            map.put(num, true);
        }
        return -1;
    }

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
