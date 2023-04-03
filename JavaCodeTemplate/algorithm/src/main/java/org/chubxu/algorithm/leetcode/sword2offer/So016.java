package org.chubxu.algorithm.leetcode.sword2offer;

public class So016 {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n>>=1;
        }
        return res;
    }
}
