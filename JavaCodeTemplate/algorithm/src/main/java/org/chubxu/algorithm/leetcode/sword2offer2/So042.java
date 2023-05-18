package org.chubxu.algorithm.leetcode.sword2offer2;

import java.util.Deque;
import java.util.LinkedList;

public class So042 {

}

class RecentCounter {

    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.addLast(t);
        while (deque.getFirst() < t-3000) {
            deque.pollFirst();
        }
        return deque.size();
    }
}
