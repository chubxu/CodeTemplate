package org.chubxu.algorithm.leetcode.qn022;

/**
 * @ClassName Lt2278
 * @Description
 *
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "foobar", letter = "o"
 * 输出：33
 * 解释：
 * 等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。
 * 示例 2：
 *
 * 输入：s = "jjjj", letter = "k"
 * 输出：0
 * 解释：
 * 等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * letter 是一个小写英文字母
 *
 * @Since 1.0.0
 * @Date 2023/1/15 23:06
 * @Author chubxu
 */
public class Lt2278 {
    public int percentageLetter(String s, char letter) {
        if (s == null || s.length() == 0) return 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter == s.charAt(i)) c++;
        }
        return (int) (c * 1.0 / s.length() * 100);
    }
}
