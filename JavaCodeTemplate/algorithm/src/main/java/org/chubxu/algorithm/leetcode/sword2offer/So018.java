package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.ListNode;

public class So018 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = dummyNode;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return dummyNode.next;
    }
}
