package org.chubxu.algorithm.leetcode.qn009;

/**
 * @ClassName Lt912
 * @Description
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 *
 * @Since 1.0.0
 * @Date 2022/11/11 21:54
 * @Author chubxu
 */
public class Lt912 {
    private int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        merge(nums, 0, nums.length-1);
        return nums;
    }

    public void merge(int[] nums, int s, int e) {
        if (s == e) {
            // 如果只有一个元素，无需排序，直接返回即可
            return ;
        }
        int m = s + (e - s) / 2;
        merge(nums, s, m);
        merge(nums, m+1, e);

        doMerge(nums, s, m, e);
    }

    public void doMerge(int[] nums, int s, int m, int e) {
        for (int i = s; i <= e; i++) {
            temp[i] = nums[i];
        }
        int l = s, r = m+1;
        for (int i = s; i<=e; i++) {
            if (l == m+1) {
                nums[i] = temp[r++];
            } else if (r == e+1) {
                nums[i] = temp[l++];
            } else if (temp[l] < temp[r]) {
                nums[i] = temp[l++];
            } else {
                nums[i] = temp[r++];
            }
        }
    }
}
