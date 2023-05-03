package org.chubxu.algorithm.leetcode.qn007;

import org.chubxu.algorithm.leetcode.TreeNode;

public class Lt783 {
    int res = Integer.MAX_VALUE, pre = -1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            res = Math.min(res, Math.abs(pre - node.val));
            pre = node.val;
        }
        dfs(node.right);
    }
}
