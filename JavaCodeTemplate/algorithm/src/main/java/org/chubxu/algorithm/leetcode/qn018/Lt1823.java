package org.chubxu.algorithm.leetcode.qn018;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Lt1823 {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < k-1; i++) {
                queue.addLast(queue.pollFirst());
            }
            queue.pollFirst();
        }
        return queue.peek();
    }

    public int findTheWinner2(int n, int k) {
        int rt = 0;
        for (int i = 2; i<n+1; i++) {
            rt = (rt + k) % i;
        }
        return rt + 1;
    }

    @Test
    public void test() {
        System.out.println(findTheWinner(6, 5));
    }
}
