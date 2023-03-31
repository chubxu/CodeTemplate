package org.chubxu.algorithm.leetcode.sword2offer;

public class So065 {
    public int add(int a, int b) {
        if (b == 0) return a;
        return add(a^b, (a&b) << 1);
    }
}
