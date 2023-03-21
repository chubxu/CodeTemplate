package org.chubxu.algorithm.leetcode.sword2offer;

public class So010_2 {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int pp = 1;
        int p = 2;
        int res = pp + p;
        for (int i = 3; i < n; i++) {
            pp = p;
            p = res;
            res = (pp + p) % 1000000007;
        }
        return res;
    }
}
