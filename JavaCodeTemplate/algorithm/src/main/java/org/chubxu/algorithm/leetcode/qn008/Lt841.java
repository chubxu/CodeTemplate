package org.chubxu.algorithm.leetcode.qn008;

import java.util.List;

public class Lt841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(visited, 0, rooms);
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    public void dfs(boolean[] visited, int n, List<List<Integer>> rooms) {
        visited[n] = true;
        List<Integer> integers = rooms.get(n);
        for (Integer integer : integers) {
            if (!visited[integer]) {

                dfs(visited, integer, rooms);
            }
        }
    }
}
