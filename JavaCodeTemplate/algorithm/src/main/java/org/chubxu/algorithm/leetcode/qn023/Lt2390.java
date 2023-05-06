package org.chubxu.algorithm.leetcode.qn023;

import org.junit.Test;

import java.util.LinkedList;

public class Lt2390 {
    public String removeStars(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '*') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(removeStars("leet**cod*e"));
    }
}
