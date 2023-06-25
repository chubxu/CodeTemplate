package org.chubxu.algorithm.leetcode.qn021;

import java.util.ArrayList;
import java.util.List;

public class Lt2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for(int i = 0; i < n; i++){
            if(nums[i] < pivot){
                ans[left++] = nums[i];
            }else if(nums[i] > pivot){
                ans[right--] = nums[i];
            }
        }
        int i = right + 1;
        int j = n - 1;
        while(i < j){
            int t = ans[i];
            ans[i] = ans[j];
            ans[j] = t;
            i++;
            j--;
        }
        for(int k = left; k <= right; k++){
            ans[k] = pivot;
        }
        return ans;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] pivotArray2(int[] nums, int pivot) {
        List<Integer> lt = new ArrayList<>();
        List<Integer> gt = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();
        for (int num : nums) {
            if (num == pivot) {
                eq.add(num);
            } else if (num < pivot) {
                lt.add(num);
            } else {
                gt.add(num);
            }
        }
        int i = 0;
        for (Integer integer : lt) {
            nums[i++] = integer;
        }
        for (Integer integer : eq) {
            nums[i++] = integer;
        }
        for (Integer integer : gt) {
            nums[i++] = integer;
        }
        return nums;
    }
}
