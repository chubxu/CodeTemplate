package org.chubxu.algorithm.leetcode.qn005;

import org.chubxu.algorithm.leetcode.TreeNode;

/**
 * @ClassName Lt543
 * @Description
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/31 0:11
 * @Author chubxu
 */
public class Lt543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return res;
    }

    public int help(TreeNode root) {
        if (root == null) return 0;
        int leftD = help(root.left);
        int leftR = help(root.right);
        int max = Math.max(leftD, leftR) + 1;
        res = Math.max(res, leftD + leftR + 1);
        return max;
    }
}
