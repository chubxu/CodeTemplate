package org.chubxu.algorithm.leetcode.qn024;

/**
 * @ClassName Lt2413
 * @Description
 *
 * 给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：10
 * 解释：5 和 2 的最小公倍数是 10 。
 * 示例 2：
 *
 * 输入：n = 6
 * 输出：6
 * 解释：6 和 2 的最小公倍数是 6 。注意数字会是它自身的倍数。
 *
 *
 * 提示：
 *
 * 1 <= n <= 150
 *
 * @Since 1.0.0
 * @Date 2023/1/28 20:05
 * @Author chubxu
 */
public class Lt2413 {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 1 ? 2 * n : n;
    }
}
