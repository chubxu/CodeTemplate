package org.chubxu.algorithm.leetcode.qn021;

public class Lt2149 {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int po = 0, ne = 0;
        while(po < nums.length && nums[po++] < 0);
        po--;
        while(ne < nums.length && nums[ne++] > 0);
        ne--;
        int index = 0;
        while (index < nums.length) {
            res[index++] = nums[po++];
            res[index++] = nums[ne++];
            while(po < nums.length && nums[po++] < 0);
            po--;
            while(ne < nums.length && nums[ne++] > 0);
            ne--;
        }
        return res;
    }

    public int[] rearrangeArray2(int[] nums) {
        int[] r = new int[nums.length];
        int idxZ = 0, idxF = 1;
        for (int n : nums)
            if (n > 0) {
                r[idxZ] = n;
                idxZ += 2;
            } else {
                r[idxF] = n;
                idxF += 2;
            }
        return r;
    }
}
