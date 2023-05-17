package org.chubxu.algorithm.leetcode.qn009;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lt950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            queue.addLast(i);
        }
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        for (int i : deck) {
            res[queue.pollFirst()] = i;
            if (!queue.isEmpty()) {
                queue.addLast(queue.pollFirst());
            }
        }
        return res;
    }
}
