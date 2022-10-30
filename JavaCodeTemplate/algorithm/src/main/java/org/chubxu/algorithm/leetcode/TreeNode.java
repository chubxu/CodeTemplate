package org.chubxu.algorithm.leetcode;

/**
 * @ClassName TreeNode
 * @Description 基础类
 * @Since 1.0.0
 * @Date 2022/10/30 23:52
 * @Author chubxu
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
