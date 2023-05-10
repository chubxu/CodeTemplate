package org.chubxu.algorithm.leetcode.qn009;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lt901 {
}

class StockSpanner {
    Stack<int[]> stack = new Stack<>();
    int idx = -1;
    public StockSpanner() {
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}
