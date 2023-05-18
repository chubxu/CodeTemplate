package org.chubxu.algorithm.leetcode.sword2offer2;

import java.util.Deque;
import java.util.LinkedList;

public class So041 {
}

class MovingAverage {

    /** Initialize your data structure here. */
    Deque<Integer> deque;
    int size;
    int sum;
    public MovingAverage(int size) {
        this.deque = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (deque.size() < size) {
            deque.addLast(val);
            sum += val;
            return sum * 1.0 / deque.size();
        } else {
            sum -= deque.pollFirst();
            deque.addLast(val);
            sum += val;
            return sum * 1.0 / size;
        }
    }
}
