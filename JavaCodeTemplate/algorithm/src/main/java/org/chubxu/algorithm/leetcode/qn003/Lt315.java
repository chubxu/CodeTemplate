package org.chubxu.algorithm.leetcode.qn003;

import java.util.*;

/**
 * @ClassName Lt315
 * @Description
 *
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 *
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @Since 1.0.0
 * @Date 2022/11/11 22:06
 * @Author chubxu
 */
public class Lt315 {
    private class Pair {
        int val, id;
        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }
    private Pair[] temp;
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] array = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = new Pair(nums[i], i);
        }
        sort(array, 0, array.length-1);
        List<Integer> res = new ArrayList<>();
        for (int i : count) {
            res.add(i);
        }
        return res;
    }

    private void sort(Pair[] array, int s, int e) {
        if (s == e) {
            return ;
        }
        int m = s + (e-s)/2;
        sort(array, s, m);
        sort(array, m+1, e);
        merge(array, s, m, e);
    }

    private void merge(Pair[] array, int s, int m, int e) {
        for (int i = s; i<=e; i++) {
            temp[i] = array[i];
        }
        int l = s, r = m+1;
        for (int i = s; i<=e; i++) {
            if (l == m+1) {
                array[i] = temp[r++];
            } else if (r == e+1) {
                array[i] = temp[l++];
                count[array[i].id] += r - m - 1;
            } else if (temp[l].val <= temp[r].val) {
                array[i] = temp[l++];
                count[array[i].id] += r - m - 1;
            } else {
                array[i] = temp[r++];
            }
        }
    }

    public static void main(String[] args) {
        Lt315 lt = new Lt315();
        int[] nums = new int[]{-1, -1};
        System.out.println(lt.countSmaller(nums));
    }
}
