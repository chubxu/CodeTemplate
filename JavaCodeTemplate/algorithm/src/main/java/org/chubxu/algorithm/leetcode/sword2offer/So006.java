package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class So006 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        h(head, list);
        int[] rt = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rt[i] = list.get(i);
        }
        return rt;
    }
    public void h(ListNode head, List<Integer> list) {
        if (head != null) {
            h(head.next, list);
            list.add(head.val);
        }
    }
}
