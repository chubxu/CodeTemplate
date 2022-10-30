package org.chubxu.algorithm.leetcode.qn002;

/**
 * @ClassName Lt283
 * @Description
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/30 21:57
 * @Author chubxu
 */
public class Lt283 {
    public void moveZeroes(int[] nums) {
        int l = removeElement(nums, 0);
        for (int i = l; i < nums.length; i++) {
            nums[l] = 0;
        }
    }
    public int removeElement(int[] nums, int target) {
        int f = 0, s = 0;
        while (f < nums.length) {
            if (nums[f] != target) {
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        return s+1;
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return ;
        }
        int j = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
                j++;
            }

        }
    }
}
