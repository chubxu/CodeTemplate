package org.chubxu.algorithm.leetcode.sword2offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class So057_2 {

    @Test
    public void test() {
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        if (target <= 1) return res.toArray(new int[][]{});
        int l = 1, r = 2;
        while (l < r) {
            if (help(l, r) == target) {
                res.add(help2(l ,r));
                l++; r++;
            } else if (help(l, r) < target) {
                r++;
            } else {
                l++;
            }
        }
        return res.toArray(new int[][]{});
    }
    public int help(int l, int r) {
        return (l + r) * (r - l + 1) / 2;
    }

    public int[] help2(int l, int r) {
        int[] res = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            res[i-l] = i;
        }
        return res;
    }
}
