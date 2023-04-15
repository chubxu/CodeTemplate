package org.chubxu.algorithm.leetcode.qn001;

public class Lt121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length > 1) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > min) {
                    res = Math.max(res, prices[i] - min);
                } else {
                    min = prices[i];
                }
            }
        }
        return res;
    }
}
