package org.chubxu.algorithm.leetcode.qn025;

/**
 * @ClassName Lt2520
 * @Description
 *
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 *
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * 示例 2：
 *
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * 示例 3：
 *
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 *
 *
 * 提示：
 *
 * 1 <= num <= 109
 * num 的数位中不含 0
 *
 * @Since 1.0.0
 * @Date 2023/1/28 20:19
 * @Author chubxu
 */
public class Lt2520 {
    public int countDigits(int num) {
        int res = 0;
        int n = num;
        while (n > 0) {
            int t = n % 10;
            res += num % t == 0 ? 1 : 0;
            n /= 10;
        }
        return res;
    }
}
