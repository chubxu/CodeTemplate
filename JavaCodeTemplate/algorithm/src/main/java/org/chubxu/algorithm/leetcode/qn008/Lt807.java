package org.chubxu.algorithm.leetcode.qn008;

public class Lt807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] columnMax = new int[n];
        int[] rowMax = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                columnMax[j] = Math.max(columnMax[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.max(grid[i][j], Math.min(columnMax[j], rowMax[i])) - grid[i][j];
            }
        }
        return res;
    }
}
