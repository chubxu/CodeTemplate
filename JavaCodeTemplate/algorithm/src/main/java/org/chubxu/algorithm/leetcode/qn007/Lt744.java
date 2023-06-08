package org.chubxu.algorithm.leetcode.qn007;

public class Lt744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length-1]) {
            return letters[0];
        }
        int l = 0, r = letters.length-1;
        while (l < r) {
            int mid = l + ((r-l) >> 1);
            if (letters[mid] <= target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return letters[l];
    }
}
