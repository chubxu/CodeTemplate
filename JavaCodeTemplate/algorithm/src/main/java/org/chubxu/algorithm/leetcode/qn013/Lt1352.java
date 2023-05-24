package org.chubxu.algorithm.leetcode.qn013;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lt1352 {
}

class ProductOfNumbers {

    int[] nums = new int[40000];
    int len = 0;

    public ProductOfNumbers() {
        nums[0] = 1;
    }

    public void add(int num) {
        if (num == 0) len = 0;
        else {
            nums[++len] = num;
            nums[len] *= nums[len-1];
        }
    }

    public int getProduct(int k) {
        if (len < k) return 0;
        return nums[len] / nums[len-k];
    }
}
