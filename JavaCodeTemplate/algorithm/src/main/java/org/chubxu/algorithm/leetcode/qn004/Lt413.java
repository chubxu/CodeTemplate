package org.chubxu.algorithm.leetcode.qn004;

/**
 * @ClassName Lt413
 * @Description
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/17 21:47
 * @Author chubxu
 */
public class Lt413 {
    /**
     * dp[i] 表示以 nums[i] 结尾的等差数列个数
     * if nums[i] - nums[i-1] == nums[i-1] - nums[i-2]: dp[i] = dp[i-1] + 1
     * else: dp[i] = 0
     * @param nums 数组
     * @return 等差子数组个数
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int[] dp = new int[nums.length];
        for (int i = 2; i<nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        int rt = 0;
        for (int i : dp) {
            rt += i;
        }
        return rt;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int cur = 0, rt = 0;
        for (int i = 2; i<nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                cur++;
            } else {
                cur = 0;
            }
            rt += cur;
        }
        return rt;
    }
}
