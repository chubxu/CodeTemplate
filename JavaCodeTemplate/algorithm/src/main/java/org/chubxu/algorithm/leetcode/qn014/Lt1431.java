package org.chubxu.algorithm.leetcode.qn014;

import java.util.ArrayList;
import java.util.List;

public class Lt1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        if (candies == null || candies.length == 0) return res;
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }


}
