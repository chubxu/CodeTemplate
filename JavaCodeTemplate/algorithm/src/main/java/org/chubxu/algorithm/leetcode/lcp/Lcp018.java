package org.chubxu.algorithm.leetcode.lcp;

import java.util.Arrays;

public class Lcp018 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long res = 0;
        int i = 0, j = drinks.length-1;
        while (i<staple.length && j>=0) {
            if (staple[i] + drinks[j] > x) {
                j--;
            } else {
                res += j+1;
                i++;
            }
        }
        return (int)res % 1000000007;
    }
}
