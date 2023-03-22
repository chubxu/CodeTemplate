package org.chubxu.algorithm.leetcode.sword2offer;

public class So012 {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, visited, word, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length()-1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] ints : direction) {
            int newI = i + ints[0];
            int newJ = j + ints[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length
                    &&!visited[newI][newJ]) {
                boolean flag = check(board, visited, word, newI, newJ, k+1);
                if (flag) {
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}
