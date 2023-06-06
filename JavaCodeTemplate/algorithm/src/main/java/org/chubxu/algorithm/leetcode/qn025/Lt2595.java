package org.chubxu.algorithm.leetcode.qn025;

public class Lt2595 {
    public int[] evenOddBit(int n) {
        var ans = new int[2];
        for (int i = 0; n > 0; i ^= 1, n >>= 1)
            ans[i] += n & 1;
        return ans;
    }

    public int[] evenOddBit2(int n) {
        final int MASK = 0x5555;
        return new int[]{Integer.bitCount(n & MASK), Integer.bitCount(n & (MASK >> 1))};
    }
}
