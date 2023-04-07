package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class So032_1 {
    public int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<Integer> rt = new ArrayList<>();
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = list.removeFirst();
                if (first != null) {
                    rt.add(first.val);
                    list.addLast(first.left);
                    list.addLast(first.right);
                }
            }
        }
        int[] rtA = new int[rt.size()];
        for (int i = 0; i < rt.size(); i++) {
            rtA[i] = rt.get(i);
        }
        return rtA;
    }
}
