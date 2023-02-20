package org.chubxu.algorithm.leetcode.qn008;

/**
 * @ClassName Lt868
 * @Description
 *
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 *
 * 输入：n = 8
 * 输出：0
 * 解释：8 的二进制是 "1000" 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 * 示例 3：
 *
 * 输入：n = 5
 * 输出：2
 * 解释：5 的二进制是 "101" 。
 *
 *
 * 提示：
 *
 * 1 <= n <= 109
 *
 * @Since 1.0.0
 * @Date 2023/2/20 22:53
 * @Author chubxu
 */
public class Lt868 {
    public static int binaryGap(int n) {
        int[] array = new int[32];
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                array[index] = 0;
            } else {
                array[index] = 1;
            }
            index++;
            n >>= 1;
        }
        int res = 0;
        boolean start = false;
        int startIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                if (!start) {
                    start = true;
                    startIndex = i;
                } else {
                    res = Math.max(res, i - startIndex);
                    startIndex = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(5));
    }
}
