package org.chubxu.algorithm.leetcode.sword2offer;

public class So062 {
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = lastRemaining(n-1, m);
        return (m + x) % n;
    }
}
