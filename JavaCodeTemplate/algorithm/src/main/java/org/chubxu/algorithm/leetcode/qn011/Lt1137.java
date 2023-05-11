package org.chubxu.algorithm.leetcode.qn011;

public class Lt1137 {
    public int tribonacci(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;
        int p = 0, pp = 1, ppp = 1;
        int res = p + pp + ppp;
        for (int i = 3; i<=n; i++) {
            res = p + pp + ppp;
            p = pp;
            pp = ppp;
            ppp = res;
        }
        return res;
    }
}
