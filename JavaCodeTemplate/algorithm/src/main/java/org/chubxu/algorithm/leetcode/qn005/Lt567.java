package org.chubxu.algorithm.leetcode.qn005;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lt567
 * @Description
 *
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @Since 1.0.0
 * @Date 2022/11/23 21:58
 * @Author chubxu
 */
public class Lt567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int valid = 0, left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            if (right - left == s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char cLeft = s2.charAt(left);
                left++;
                if (need.containsKey(cLeft)) {
                    if (window.get(cLeft).equals(need.get(cLeft))) {
                        valid--;
                    }
                    window.put(cLeft, window.get(cLeft) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lt567 lt = new Lt567();
        System.out.println(lt.checkInclusion("hello", "ooolleoooleh"));
    }
}
