package org.chubxu.algorithm.leetcode.qn016;

import java.util.*;

/**
 * @ClassName Lt1636
 * @Description
 *
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 *
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @Since 1.0.0
 * @Date 2023/1/31 22:38
 * @Author chubxu
 */
public class Lt1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int p1 = map.get(o1);
                int p2 = map.get(o2);
                return p1 == p2 ? o1 - o2 : p1 - p2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
