package org.chubxu.algorithm.leetcode.qn013;

import org.chubxu.algorithm.leetcode.TreeNode;

public class Lt1379 {
    TreeNode res = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        help(original, cloned, target);
        return res;
    }

    public void help(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || res != null) {
            return ;
        }
        getTargetCopy(original.left, cloned.left, target);
        if (original == target) {
            res = cloned;
            return ;
        }
        getTargetCopy(original.right, cloned.right, target);
    }
}
