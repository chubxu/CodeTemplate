package org.chubxu.algorithm.leetcode.qn002;

import org.junit.Test;

import java.util.Arrays;

public class Lt238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length-1; i>=0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
