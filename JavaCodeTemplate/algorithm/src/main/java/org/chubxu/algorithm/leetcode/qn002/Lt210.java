package org.chubxu.algorithm.leetcode.qn002;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lt210
 * @Description
 *
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *
 *
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 *
 * @Since 1.0.0
 * @Date 2022/11/30 21:33
 * @Author chubxu
 */
public class Lt210 {
    List<List<Integer>> list = new ArrayList<>();
    int res[];
    int index;
    boolean canFind = true;
    int[] visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index = numCourses-1;
        res = new int[numCourses];
        visited = new int[numCourses];
        list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && canFind) {
                dfs(i);
            }
        }
        if (!canFind) {
            return new int[]{};
        }
        return res;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (Integer integer : list.get(i)) {
            if (visited[integer] == 0) {
                if (canFind)
                    dfs(integer);
            } else if (visited[integer] == 1) {
                canFind = false;
                return ;
            }
        }
        res[index--] = i;
        visited[i] = 2;
    }
}
