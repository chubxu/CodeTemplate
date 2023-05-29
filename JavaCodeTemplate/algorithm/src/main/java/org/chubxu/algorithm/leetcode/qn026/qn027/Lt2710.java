package org.chubxu.algorithm.leetcode.qn026.qn027;

import org.junit.Test;

public class Lt2710 {
    public String removeTrailingZeros(String num) {
        int l = num.length()-1;
        while (l >= 0) {
            if (num.charAt(l) == '0') {
                l--;
            } else {
                break;
            }
        }
        return num.substring(0, l+1);
    }

    @Test
    public void test() {
        System.out.println(removeTrailingZeros("123"));
    }
}
