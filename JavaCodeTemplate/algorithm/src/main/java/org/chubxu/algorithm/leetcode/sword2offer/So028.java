package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

public class So028 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return help(root.left, root.right);
    }

    public boolean help(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return help(l.left, r.right) && help(l.right, r.left);
    }
}
