package org.chubxu.algorithm.leetcode.qn003;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lt345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'));
        int l = 0, r = s.length()-1;
        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < r && !set.contains(chars[l])) l++;
            while (l < r && !set.contains(chars[r])) r--;
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        System.out.println(reverseVowels("leetcode"));
    }
}
