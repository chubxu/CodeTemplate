package org.chubxu.algorithm.leetcode.qn026;

public class Lt2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        if (k < numOnes + numZeros) {
            return k - numOnes;
        }
        return 2 * numOnes - k + numZeros;
    }
}
