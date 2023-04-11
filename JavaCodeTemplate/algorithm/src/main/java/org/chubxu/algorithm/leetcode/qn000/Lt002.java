package org.chubxu.algorithm.leetcode.qn000;

import org.chubxu.algorithm.leetcode.ListNode;

public class Lt002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, l1);
        ListNode cur = dummy;
        boolean jw = false;
        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + (jw ? 1 : 0);
            jw = total / 10 == 1;
            l1.val = total % 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int total = l1.val + (jw ? 1 : 0);
            jw = total / 10 == 1;
            l1.val = total % 10;
            l1 = l1.next;
            cur = cur.next;
        }
        if (l2 != null) {
            cur.next = l2;
            while (l2 != null) {
                int total = l2.val + (jw ? 1 : 0);
                jw = total / 10 == 1;
                l2.val = total % 10;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (jw) {
            cur.next = new ListNode(1, null);
        }
        return dummy.next;
    }
}
