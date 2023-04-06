package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

public class So026 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean help(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return help(a.left, b.left) && help(a.right, b.right);
    }
}
