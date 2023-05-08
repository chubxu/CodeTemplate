package org.chubxu.algorithm.leetcode.qn007;

import java.util.Stack;

public class Lt739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
