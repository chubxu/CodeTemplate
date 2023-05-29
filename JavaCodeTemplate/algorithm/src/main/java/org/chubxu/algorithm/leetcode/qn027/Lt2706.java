package org.chubxu.algorithm.leetcode.qn027;

import java.util.Arrays;

public class Lt2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] > money) {
            return money;
        } else {
            return money - prices[0] - prices[1];
        }
    }
}
