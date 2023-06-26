package org.chubxu.algorithm.leetcode.qn021;

import org.chubxu.algorithm.leetcode.ListNode;

public class Lt2130 {
    int res = 0;
    ListNode root;
    public int pairSum(ListNode head) {
        root = head;
        help(head);
        return res;
    }

    public void help(ListNode head) {
        if (head == null) return;
        help(head.next);
        res = Math.max(res, head.val + root.val);
        root = root.next;
    }

    public int pairSum2(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        ListNode r = new ListNode();
        r.next = null;
        while(q != null && q.next != null){
            q = q.next.next;
            ListNode m = p.next;
            p.next = r.next;
            r.next = p;
            p = m;
        }
        q = r.next;
        int result = Integer.MIN_VALUE;
        while(p != null){
            if(result < (p.val + q.val)){
                result = p.val + q.val;
            }
            p = p.next;
            q = q.next;
        }
        return result;
    }
}
