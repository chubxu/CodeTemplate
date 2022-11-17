package org.chubxu.algorithm.leetcode.qn004;

import org.chubxu.algorithm.leetcode.TreeNode;

/**
 * @ClassName Lt450
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/11/17 22:16
 * @Author chubxu
 */
public class Lt450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = getMinNode(root.right);

                // 将min节点与父节点断开
                root.right = deleteNode(root.right, min.val);

                min.left = root.left;
                min.right = root.right;
                root = min;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    private TreeNode getMinNode(TreeNode node) {
        if (node != null && node.left != null) {
            return getMinNode(node.left);
        }
        return node;
    }
}
