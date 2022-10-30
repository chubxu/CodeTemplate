package org.chubxu.algorithm.leetcode.qn000;

/**
 * @ClassName Lt005
 * @Description
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/30 22:36
 * @Author chubxu
 */
public class Lt005 {
    public String longestPalindrome(String s) {
        int len = s.length();
        char[] array = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        String res = "";
        int max = 0;
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j<len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j-i == 1) {
                    dp[i][j] = array[i] == array[j];
                } else {
                    dp[i][j] = dp[i+1][j-1] && (array[i] == array[j]);
                }
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }
}
