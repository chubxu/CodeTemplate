package org.chubxu.algorithm.leetcode.qn009;

/**
 * @ClassName Lt997
 * @Description TODO
 * @Since 1.0.0
 * @Date 2023/2/21 23:20
 * @Author chubxu
 */
public class Lt997 {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n+1];
        for (int[] ints : trust) {
            arr[ints[0]]--;
            arr[ints[1]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n-1) return i;
        }
        return -1;
    }
}
