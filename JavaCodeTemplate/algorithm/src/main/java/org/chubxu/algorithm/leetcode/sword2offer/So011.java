package org.chubxu.algorithm.leetcode.sword2offer;

public class So011 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length-1;
        while (i < j) {
            int m = i + (j-i) / 2;
            if (numbers[m] > numbers[j]) {
                i = m+1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                int x = i;
                for(int k = i + 1; k < j; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }
}
