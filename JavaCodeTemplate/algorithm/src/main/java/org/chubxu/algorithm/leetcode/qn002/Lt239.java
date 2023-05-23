package org.chubxu.algorithm.leetcode.qn002;

import java.util.LinkedList;

public class Lt239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i<k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i<nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            while (queue.getFirst() <= i - k) {
                queue.pollFirst();
            }
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}
