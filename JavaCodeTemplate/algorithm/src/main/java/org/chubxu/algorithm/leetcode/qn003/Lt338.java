package org.chubxu.algorithm.leetcode.qn003;

public class Lt338 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }
}
