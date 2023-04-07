package org.chubxu.algorithm.leetcode.sword2offer;

import java.util.Stack;

public class So031 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (int i : pushed) {
            stack.add(i);
            while (!stack.isEmpty() && stack.peek() == popped[cur]) {
                stack.pop();
                cur++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        So031 so = new So031();
        int[] pushed = new int[] {1,2,3,4,5};
        int[] popped = new int[] {4,5,3,2,1};
        System.out.println(so.validateStackSequences(pushed, popped));
    }
}
