package org.chubxu.algorithm.leetcode.qn010;

import org.junit.Test;

public class Lt1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int l1, int l2) {
        if (l2 == 0) {
            return l1;
        }
        int r;
        do {
            r = l1 % l2;
            l1 = l2;
            l2 = r;
        } while (r != 0);
        return l1;
    }

    @Test
    public void testGcd() {
        System.out.println(gcd(10, 15));
    }

    @Test
    public void test() {
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }
}
