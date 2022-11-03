package org.chubxu.algorithm.leetcode.qn002;

import org.chubxu.algorithm.leetcode.TreeNode;

/**
 * @ClassName Lt226
 * @Description
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @Since 1.0.0
 * @Date 2022/11/3 22:38
 * @Author chubxu
 */
public class Lt226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        help(root);
        return root;
    }

    public void help(TreeNode node) {
        if(node == null) return;

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        help(node.left);
        help(node.right);
    }

}
