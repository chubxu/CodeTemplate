package org.chubxu.algorithm.leetcode.qn006;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lt649 {
    public String predictPartyVictory(String senate) {
        Deque<Integer> r = new ArrayDeque<>();
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.addLast(i);
            } else {
                d.addLast(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            if (r.getFirst() < d.getFirst()) {
                d.pollFirst();
                r.addLast(r.pollFirst() + senate.length());
            } else {
                r.pollFirst();
                d.addLast(d.pollFirst() + senate.length());
            }
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }

    @Test
    public void test() {
        System.out.println(predictPartyVictory("R"));
    }
}
