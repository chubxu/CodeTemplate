package org.chubxu.algorithm.leetcode.qn018;

public class Lt1844 {
    public static String replaceDigits(String s) {
        char[] rt = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ((i&1) == 0) {
                rt[i] = s.charAt(i);
            } else {
                rt[i] = (char) (s.charAt(i-1) + (s.charAt(i) - '0'));
            }
        }
        return new String(rt);
    }

    public static void main(String[] args) {
        replaceDigits("a1dde1");
    }
}
