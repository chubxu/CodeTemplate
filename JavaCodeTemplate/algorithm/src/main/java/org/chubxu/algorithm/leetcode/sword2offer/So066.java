package org.chubxu.algorithm.leetcode.sword2offer;

public class So066 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len == 0) return a;
        int[] L = new int[len];
        int[] R = new int[len];

        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = a[i-1] * L[i-1];
        }

        R[len-1] = 1;
        for (int i = len-2; i>=0; i--) {
            R[i] = a[i+1] * R[i+1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }
}
