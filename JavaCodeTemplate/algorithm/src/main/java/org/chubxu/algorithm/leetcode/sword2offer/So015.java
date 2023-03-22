package org.chubxu.algorithm.leetcode.sword2offer;

public class So015 {
    public int hammingWeight(int n) {
        int rt = 0;
        while (n != 0) {
            n &= n-1;
            rt++;
        }
        return rt;
    }
}
