package org.chubxu.algorithm.leetcode.qn005;

/**
 * @ClassName Lt504
 * @Description
 *
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 *
 *
 *
 * 示例 1:
 *
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: num = -7
 * 输出: "-10"
 *
 *
 * 提示：
 *
 * -107 <= num <= 107
 *
 * @Since 1.0.0
 * @Date 2023/1/6 22:01
 * @Author chubxu
 */
public class Lt504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean n = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num / 7 != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num);
        if (n) {
            sb.append("~");
        }
        return sb.reverse().toString();
    }
}
