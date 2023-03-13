package org.chubxu.algorithm.leetcode.qn021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lt2154 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original*=2;
            }
        }
        return original;
    }

    public int findFinalValue2(int[] nums, int original) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums) set.add(n);
        while(set.contains(original)) original*=2;
        return original;
    }
}
