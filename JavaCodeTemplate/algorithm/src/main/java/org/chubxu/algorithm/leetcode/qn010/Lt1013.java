package org.chubxu.algorithm.leetcode.qn010;

/**
 * @ClassName Lt1013
 * @Description
 *
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 5 * 104
 * -104 <= arr[i] <= 104
 *
 * @Since 1.0.0
 * @Date 2023/2/1 22:27
 * @Author chubxu
 */
public class Lt1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int l = 0;
        int target = sum / 3;
        int cur = 0;
        while (l < arr.length) {
            cur += arr[l];
            if (cur == target) {
                break;
            }
            l++;
        }
        if (cur != target) {
            return false;
        }
        int r = l+1;
        while (r+1 < arr.length) {
            cur += arr[r];
            if (cur == target * 2) {
                return true;
            }
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        Lt1013 lt1013 = new Lt1013();
        int[] arr = new int[]{3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(lt1013.canThreePartsEqualSum(arr));
    }
}
