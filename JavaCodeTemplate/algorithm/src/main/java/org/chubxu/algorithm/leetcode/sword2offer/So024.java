package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.ListNode;

public class So024 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
