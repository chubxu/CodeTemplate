package org.chubxu.algorithm.leetcode.qn023;

import org.chubxu.algorithm.leetcode.TreeNode;

public class Lt2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0 || root.val == 1) {
            return root.val != 0;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
