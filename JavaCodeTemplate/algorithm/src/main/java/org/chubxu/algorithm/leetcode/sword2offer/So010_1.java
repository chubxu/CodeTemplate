package org.chubxu.algorithm.leetcode.sword2offer;

public class So010_1 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int pp = 0;
        int p = 1;
        int res = pp + p;
        for (int i = 2; i < n; i++) {
            pp = p;
            p = res;
            res = (pp + p) % 1000000007;

        }
        return res;
    }
}
