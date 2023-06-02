package org.chubxu.algorithm.leetcode.qn026;

public class Lt2639 {
    public int[] findColumnWidth(int[][] grid) {
        int lenX = grid.length, lenY = grid[0].length, arr[] = new int[lenY];
        for (int i = 0;i < lenY;i++) {
            int max = 0;
            for (int j = 0;j < lenX;j++) {
                max = Math.max(String.valueOf(grid[j][i]).length(), max);
            }
            arr[i] = max;
        }
        return arr;
    }
}
