package org.chubxu.algorithm.leetcode.qn014;

import java.util.LinkedList;
import java.util.Queue;

public class Lt1438 {
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> queueMax = new LinkedList<>();
        LinkedList<Integer> queueMin = new LinkedList<>();
        int l = 0, r = 0;
        int rt = 0;
        while (r < nums.length) {
            while (!queueMax.isEmpty() && queueMax.getLast() < nums[r]) {
                queueMax.pollLast();
            }
            while (!queueMin.isEmpty() && queueMin.getLast() > nums[r]) {
                queueMin.pollLast();
            }
            queueMax.addLast(nums[r]);
            queueMin.addLast(nums[r]);
            while (!queueMax.isEmpty() && !queueMin.isEmpty() && queueMax.peekFirst() - queueMin.peekFirst() > limit) {
                if (nums[l] == queueMax.peekFirst()) {
                    queueMax.pollFirst();
                }
                if (nums[l] == queueMin.peekFirst()) {
                    queueMin.pollFirst();
                }
                l++;
            }
            rt = Math.max(rt, r - l + 1);
            r++;
        }
        return rt;
    }
}
