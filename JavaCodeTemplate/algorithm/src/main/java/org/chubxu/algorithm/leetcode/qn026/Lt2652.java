package org.chubxu.algorithm.leetcode.qn026;

public class Lt2652 {
    public int sumOfMultiples(int n) {
        return s(n, 3) + s(n, 5) + s(n, 7) - s(n, 15) - s(n, 21) - s(n, 35) + s(n, 105);
    }

    private int s(int n, int m) {
        return (1 + n / m) * (n / m) / 2 * m;
    }

}
