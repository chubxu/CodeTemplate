package org.chubxu.algorithm.leetcode.sword2offer;

import java.util.Stack;

public class So009 {
}
class CQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.empty() ? -1 : out.pop();
    }
}
