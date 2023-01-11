package org.chubxu.algorithm.leetcode.qn012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Lt1200
 * @Description
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * 每对元素对 [a,b] 如下：
 *
 * a , b 均为数组 arr 中的元素
 * a < b
 * b - a 等于 arr 中任意两个元素的最小绝对差
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 *
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * @Since 1.0.0
 * @Date 2023/1/11 23:09
 * @Author chubxu
 */
public class Lt1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> rt = new ArrayList<>();
        for (int i = 1; i<arr.length; i++) {
            if (arr[i] - arr[i-1] < min) {
                min = arr[i] - arr[i-1];
                rt.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                rt.add(pair);
            } else if (arr[i] - arr[i-1] == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                rt.add(pair);
            }
        }
        return rt;
    }
}
