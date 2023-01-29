package org.chubxu.algorithm.leetcode.qn021;

import java.util.Arrays;

/**
 * @ClassName Lt2160
 * @Description
 *
 * 给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
 *
 * 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
 * 请你返回可以得到的 new1 和 new2 的 最小 和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 2932
 * 输出：52
 * 解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
 * 最小和为数对 [29, 23] 的和：29 + 23 = 52 。
 * 示例 2：
 *
 * 输入：num = 4009
 * 输出：13
 * 解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
 * 最小和为数对 [4, 9] 的和：4 + 9 = 13 。
 *
 *
 * 提示：
 *
 * 1000 <= num <= 9999
 *
 * @Since 1.0.0
 * @Date 2023/1/29 22:27
 * @Author chubxu
 */
public class Lt2160 {
    public int minimumSum(int num) {
        int[] count = new int[4];
        int index = 0;
        while(num > 0) {
            count[index++] = num % 10;
            num /= 10;
        }
        Arrays.sort(count);
        return count[0] * 10 + count[2] + count[1] * 10 + count[3];
    }
}
