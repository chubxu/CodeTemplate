package org.chubxu.algorithm.leetcode.sword2offer;

public class So004 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int ri = 0, ci = matrix[0].length-1;
        while (ri < matrix.length && ci >= 0) {
            if (matrix[ri][ci] > target) {
                ci--;
            } else if (matrix[ri][ci] < target) {
                ri++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,4,7,11,15};
        matrix[1] = new int[]{2,5,8,12,19};
        matrix[2] = new int[]{3,6,9,16,22};
        matrix[3] = new int[]{10,13,14,17,24};
        matrix[4] = new int[]{18,21,23,26,30};
        System.out.println(findNumberIn2DArray(matrix, 5));
    }
}
