package org.chubxu.algorithm.leetcode.qn008;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lt872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!Objects.equals(list1.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return ;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
