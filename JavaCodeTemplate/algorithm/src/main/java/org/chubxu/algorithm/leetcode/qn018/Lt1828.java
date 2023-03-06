package org.chubxu.algorithm.leetcode.qn018;

/**
 * @ClassName Lt1828
 * @Description
 *
 * 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 *
 * 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 *
 * 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 *
 * 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * 输出：[3,2,2]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
 * 示例 2：
 *
 *
 * 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 *
 * @Since 1.0.0
 * @Date 2023/3/6 22:28
 * @Author chubxu
 */
public class Lt1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] rt = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                boolean gt = ((queries[i][0] - point[0]) * (queries[i][0] - point[0])
                        + (queries[i][1] - point[1]) * (queries[i][1] - point[1]))
                        > queries[i][2] * queries[i][2];
                if (!gt) {
                    rt[i]++;
                }
            }

        }
        return rt;
    }
}
