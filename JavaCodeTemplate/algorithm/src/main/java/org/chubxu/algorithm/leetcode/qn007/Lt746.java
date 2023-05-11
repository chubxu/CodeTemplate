package org.chubxu.algorithm.leetcode.qn007;

public class Lt746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) return cost[0];
        if (cost.length <= 2) return Math.min(cost[1], cost[0]);
        int[] res = new int[cost.length];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            res[i] = Math.min(res[i-1], res[i-2]) + cost[i];
        }
        return Math.min(res[cost.length-1], res[cost.length-2]);
    }
}
