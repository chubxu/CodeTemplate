package org.chubxu.algorithm.leetcode.qn013;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Lt1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int res = 0;
        while (deque.size() > 0) {
            res = 0;
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = deque.pollFirst();
                res += treeNode.val;
                if (treeNode.left != null) deque.addLast(treeNode.left);
                if (treeNode.right != null) deque.addLast(treeNode.right);
            }
        }
        return res;
    }
}
