package org.chubxu.algorithm.leetcode.qn004;

import java.util.Arrays;

/**
 * @ClassName Lt416
 * @Description
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/17 22:42
 * @Author chubxu
 */
public class Lt416 {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int mid = 0;
        for (int num : nums) {
            mid += num;
            if (sum / 2 == mid) return true;
        }
        return false;
    }
}
