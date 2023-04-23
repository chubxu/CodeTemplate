package org.chubxu.algorithm.leetcode.qn001;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

public class Lt151 {
    public String reverseWords(String s) {
        int start, end;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ') continue;
            end = i+1;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            start = i+1;
            for (int j = start; j<end; j++) {
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    @Test
    public void test() {
        String str = " 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU";
        System.out.println(reverseWords(str));
    }
}
