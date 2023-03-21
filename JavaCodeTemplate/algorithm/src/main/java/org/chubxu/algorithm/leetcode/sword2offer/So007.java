package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class So007 {
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int preorderS, int preorderE, int[] inorder, int inorderS, int inorderE) {
        if (preorderS > preorderE) {
            return null;
        }
        int preorderRoot = preorderS;
        int inorderRoot = map.get(preorder[preorderRoot]);
        TreeNode rootNode = new TreeNode(preorder[preorderRoot]);

        int leftTreeLength = inorderRoot - inorderS;
        rootNode.left = helper(preorder, preorderS+1, preorderS+leftTreeLength, inorder, inorderS, inorderRoot-1);
        rootNode.right = helper(preorder, preorderS+leftTreeLength+1, preorderE, inorder, inorderRoot+1, inorderE);
        return rootNode;
    }


}
