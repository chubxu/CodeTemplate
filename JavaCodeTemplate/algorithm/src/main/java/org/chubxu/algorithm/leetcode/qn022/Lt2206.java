package org.chubxu.algorithm.leetcode.qn022;


public class Lt2206 {
    public boolean divideArray(int[] nums) {
        int [] bucket = new int[500];
        for (int num : nums) {
            if (bucket[num-1] == 0) {
                bucket[num-1]++;
            } else {
                bucket[num-1]--;
            }
        }
        int res = 0;
        for (int i : bucket) {
            res+=i;
        }
        return res==0;
    }
}
