package org.chubxu.algorithm.leetcode.qn026;

public class Lt2697 {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length-1;
        while (l < r) {
            if (chars[l] == chars[r]) {
            } else if (chars[l] < chars[r]) {
                chars[r] = chars[l];
            } else {
                chars[l] = chars[r];
            }
            l++;
            r--;
        }
        return new String(chars);
    }
}
