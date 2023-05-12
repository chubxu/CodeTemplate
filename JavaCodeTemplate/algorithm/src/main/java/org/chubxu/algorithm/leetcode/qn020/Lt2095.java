package org.chubxu.algorithm.leetcode.qn020;

import org.chubxu.algorithm.leetcode.ListNode;

public class Lt2095 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode f = head, s = dummy;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
}
