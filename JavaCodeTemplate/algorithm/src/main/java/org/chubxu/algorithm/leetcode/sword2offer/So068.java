package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

public class So068 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return l == null ? r : (r == null ? l : root);
    }
}
