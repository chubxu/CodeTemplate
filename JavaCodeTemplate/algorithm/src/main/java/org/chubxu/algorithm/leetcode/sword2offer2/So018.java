package org.chubxu.algorithm.leetcode.sword2offer2;

public class So018 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length-1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(chars[r])) {
                r--;
            }
            if (chars[l] != chars[r] && chars[l] != (chars[r]^32)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
