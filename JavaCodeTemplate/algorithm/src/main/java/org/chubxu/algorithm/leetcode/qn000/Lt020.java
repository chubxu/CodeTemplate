package org.chubxu.algorithm.leetcode.qn000;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;
public class Lt020 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Character> map = Map.of(
                ']', '[',
                '}', '{',
                ')', '('
        );
        LinkedList<Character> stack = new LinkedList<>();
        for (char aChar : chars) {
            if (stack.isEmpty() || map.get(aChar) != stack.peek()) {
                stack.push(aChar);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test() {
        System.out.println(isValid("()"));
    }
}
