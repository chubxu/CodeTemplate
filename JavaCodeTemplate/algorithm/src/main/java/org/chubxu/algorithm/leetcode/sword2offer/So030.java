package org.chubxu.algorithm.leetcode.sword2offer;

import java.util.Objects;
import java.util.Stack;

public class So030 {
}

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.add(x);
        }
    }

    public void pop() {
        if (Objects.equals(stack.pop(), min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
