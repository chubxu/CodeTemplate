package org.chubxu.algorithm.leetcode.qn024;

/**
 * @ClassName Lt2423
 * @Description
 *
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，使得 word 中剩余每个字母出现 频率 相同。
 *
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 *
 * 注意：
 *
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 *
 *
 * 示例 1：
 *
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
 * 示例 2：
 *
 * 输入：word = "aazz"
 * 输出：false
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
 *
 *
 * 提示：
 *
 * 2 <= word.length <= 100
 * word 只包含小写英文字母。
 *
 * @Since 1.0.0
 * @Date 2023/2/12 15:58
 * @Author chubxu
 */
public class Lt2423 {
    public boolean equalFrequency(String word) {
        char[] nums = word.toCharArray();
        int[] cnt = new int[256];
        int n = nums.length;
        int maxCnt = 0;  //数字出现的最大次数
        int maxCntCnt = 0; //数字出现的最大次数的次数
        int res = 0;
        int times = 0;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] == 1) {
                times++;
            }
            if (maxCnt < cnt[nums[i]]) {
                maxCnt = cnt[nums[i]];
                maxCntCnt = 1;
            } else if (maxCnt == cnt[nums[i]]) {
                maxCntCnt++;
            }
            //情况一  "abcde"
            //情况二  "aabbccd"
            //情况三  "aabbccc"
            if ((maxCnt == 1) || (maxCnt * maxCntCnt == i) || (maxCntCnt == 1 && (maxCnt - 1) * times == i)) {
                res = i + 1;
            }
        }
        return res == n;
    }
}
