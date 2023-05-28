package org.chubxu.algorithm.leetcode.qn026;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Lt2696 {
    public int minLength(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && aChar == 'B') || (stack.peek() == 'C' && aChar == 'D'))) {
                stack.pop();
                continue;
            } else {
                stack.push(aChar);
            }
        }
        return stack.size();
    }

    @Test
    public void test() {
        System.out.println(minLength("ACBBD"));
    }
}
