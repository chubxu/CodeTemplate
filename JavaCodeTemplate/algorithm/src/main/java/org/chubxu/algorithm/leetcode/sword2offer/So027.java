package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

public class So027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }
}
