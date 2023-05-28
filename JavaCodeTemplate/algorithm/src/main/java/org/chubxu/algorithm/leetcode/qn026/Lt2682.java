package org.chubxu.algorithm.leetcode.qn026;

public class Lt2682 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        int m = n;
        for (int i = 0, d = k; !visited[i]; d+=k, m--) {
            visited[i] = true;
            i = (i + d) % n;
        }
        int[] ans = new int[m];
        for (int i = 0, j = 0; i < n; i++)
            if (!visited[i])
                ans[j++] = i + 1;
        return ans;
    }
}
