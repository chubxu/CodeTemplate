package org.chubxu.algorithm.leetcode.qn001;

import org.chubxu.algorithm.leetcode.TreeNode;

/**
 * @ClassName Lt104
 * @Description
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/30 23:51
 * @Author chubxu
 */
public class Lt104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxL = maxDepth(root.left) + 1;
        int maxR = maxDepth(root.right) + 1;
        return Math.max(maxL, maxR);
    }
}
