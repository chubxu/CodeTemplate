package org.chubxu.algorithm.leetcode.qn020;

public class Lt2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < tickets.length; i++) {
            ans += Math.min(tickets[i], i <= k ? tickets[k] : tickets[k] - 1);
        }
        return ans;
    }
}
