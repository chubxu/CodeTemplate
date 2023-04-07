package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class So032_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<List<Integer>> rt = new ArrayList<>();
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = list.removeFirst();
                if (first != null) {
                    l.add(first.val);
                    list.addLast(first.left);
                    list.addLast(first.right);
                }
            }
            if (l.size() != 0) {
                rt.add(l);
            }

        }
        return rt;
    }
}
