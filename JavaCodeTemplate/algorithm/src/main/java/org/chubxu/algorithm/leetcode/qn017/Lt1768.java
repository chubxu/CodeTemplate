package org.chubxu.algorithm.leetcode.qn017;

import org.junit.Test;

public class Lt1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int smallLen = Math.min(word1.length(), word2.length());
        for (i = 0; i<smallLen; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (i < word2.length()) {
            sb.append(word2.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public String mergeAlternatel2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i=0;
        while(i<word1.length()+word2.length()){
            if (i < word1.length()) sb.append(word1.charAt(i));

            if (i < word2.length()) sb.append(word2.charAt(i));
            i++;
        }

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(mergeAlternately("abcd", "pq"));
    }
}
