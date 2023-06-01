package org.chubxu.algorithm.leetcode.qn026;

import org.junit.Test;

public class Lt2644 {

    public int maxDivScore(int[] nums, int[] divisors) {
        int ans=-1,max=-1;
        for(int a:divisors){
            int count=0;
            for(int b:nums){if(b%a==0){count++;}}
            if(count>max||count==max&&ans>a){
                max=count;
                ans=a;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(maxDivScore(
                new int[]{4,7,9,3,9},
                new int[]{5,2,3}
        ));
    }
}
