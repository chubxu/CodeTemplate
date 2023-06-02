package org.chubxu.algorithm.leetcode.qn026;

public class Lt2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int temp = 0;
            for (int i1 = 0; i1 < mat[i].length; i1++) {
                if (mat[i][i1] == 1) {
                    temp++;
                }
                if (temp > res[1]) {
                    res[1] = temp;
                    res[0] = i;
                }
            }
        }
        return res;
    }
}
