package org.chubxu.algorithm.leetcode.sword2offer;

public class So029 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int r = matrix.length;
        int c = matrix[0].length;
        int[] rt = new int[r * c];
        int top = 0, right = c-1, bottom = r-1, left = 0;
        int cur = 0;
        while (cur < r * c) {
            for (int i = left; i <= right; i++) {
                rt[cur++] = matrix[top][i];
            }
            top++;
            if (top > bottom) return rt;
            for (int i = top; i<=bottom; i++) {
                rt[cur++] = matrix[i][right];
            }
            right--;
            if (left > right) return rt;
            for (int i = right; i>=left; i--) {
                rt[cur++] = matrix[bottom][i];
            }
            bottom--;
            if (top > bottom) return rt;
            for (int i = bottom; i>=top; i--) {
                rt[cur++] = matrix[i][left];
            }
            left++;
            if (left > right) return rt;
        }
        return rt;
    }
}
