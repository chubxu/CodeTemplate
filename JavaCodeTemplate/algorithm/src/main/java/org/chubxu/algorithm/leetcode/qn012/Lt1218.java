package org.chubxu.algorithm.leetcode.qn012;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lt1218
 * @Description
 *
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 105
 * -104 <= arr[i], difference <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/20 22:26
 * @Author chubxu
 */
public class Lt1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i<arr.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            int prev = arr[i]-difference;
            dp[i][1] = 1;
            if (map.containsKey(prev)) {
                dp[i][1] = Math.max(dp[map.get(prev)][1]+1, dp[i][1]);
            }
        }
        return Math.max(dp[arr.length-1][0], dp[arr.length-1][1]);
    }

    public int longestSubsequence2(int[] arr, int d) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i - d, 0) + 1);
            ans = Math.max(ans, map.get(i));
        }
        return ans;
    }
}
