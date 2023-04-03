package org.chubxu.algorithm.leetcode.sword2offer;

import org.chubxu.algorithm.leetcode.ListNode;

public class So022 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
