package org.chubxu.algorithm.leetcode.qn004;

public class Lt443 {
    public int compress(char[] chars) {
        int res = 0;
        int cur = 1;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1]) {
                cur++;
            } else {
                res += (cur / 10) + 2;
                cur = 1;
            }
        }
        return res;
    }
}
