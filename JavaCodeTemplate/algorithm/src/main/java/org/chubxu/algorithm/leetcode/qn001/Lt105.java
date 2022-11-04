package org.chubxu.algorithm.leetcode.qn001;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Lt105
 * @Description
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * @Since 1.0.0
 * @Date 2022/11/4 22:12
 * @Author chubxu
 */
public class Lt105 {
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart < preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndexInInorder = map.get(rootVal);
        int leftChildrenLength = rootIndexInInorder - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preStart+1, preStart+leftChildrenLength, inorder, inStart, rootIndexInInorder-1);
        root.right = helper(preorder, preStart+leftChildrenLength+1, preEnd, inorder, rootIndexInInorder+1, inEnd);
        return root;
    }
}
