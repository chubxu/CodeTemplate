package org.chubxu.algorithm.leetcode.sword2offer2;

public class So019 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return help(chars, l+1, r) || help(chars, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean help(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
