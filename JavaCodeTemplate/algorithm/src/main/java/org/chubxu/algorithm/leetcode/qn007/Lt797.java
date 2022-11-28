package org.chubxu.algorithm.leetcode.qn007;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Lt797
 * @Description
 *
 * 797. 所有可能的路径
 * 中等
 * 353
 * 相关企业
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 *
 * 提示：
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 *
 * @Since 1.0.0
 * @Date 2022/11/28 22:23
 * @Author chubxu
 */
public class Lt797 {
    List<List<Integer>> res = new LinkedList<>();
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(new LinkedList<>(), 0, graph);
        return res;
    }
    public void dfs(LinkedList<Integer> list, int s, int[][] graph) {
        list.add(s);
        if (s == graph.length-1) {
            res.add(new LinkedList<>(list));
        }
        for (int i : graph[s]) {
            dfs(list, i, graph);
        }
        list.removeLast();
    }
}
