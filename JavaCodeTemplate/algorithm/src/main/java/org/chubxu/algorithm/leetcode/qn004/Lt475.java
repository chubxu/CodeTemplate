package org.chubxu.algorithm.leetcode.qn004;

import java.util.Arrays;

public class Lt475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, r = (int)1e9;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(houses, heaters, mid)) r = mid;
            else l = mid+1;
        }

        return r;
    }

    public boolean check(int[] houses, int[] heaters, int x) {
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j < heaters.length && houses[i] > heaters[j] + x) j++;
            if (j < heaters.length && houses[i] <= heaters[j] + x && houses[i] >= heaters[j] - x) continue;
            return false;
        }
        return true;
    }
}
