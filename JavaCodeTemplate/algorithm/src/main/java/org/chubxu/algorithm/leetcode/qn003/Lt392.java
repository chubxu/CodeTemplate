package org.chubxu.algorithm.leetcode.qn003;

import org.junit.Test;

import java.util.Objects;

public class Lt392 {
    public boolean isSubsequence(String s, String t) {
        int l = 0, r = 0;
        if (Objects.isNull(s) || Objects.isNull(t)) return false;
        if (s.length() > t.length()) return false;
        while (l < s.length() && r < t.length()) {
            if (s.charAt(l) == t.charAt(r)) {
                l++;
            }
            r++;
        }
        return l == s.length();
    }

    @Test
    public void test() {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
