package org.chubxu.algorithm.leetcode.qn002;

import org.chubxu.algorithm.leetcode.ListNode;

/**
 * @ClassName Lt234
 * @Description
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/11/1 23:16
 * @Author chubxu
 */
public class Lt234 {
    ListNode left;
    public boolean isPalindrome2(ListNode head) {
        left = head;
        return help(head);
    }

    public boolean help(ListNode node) {
        if (node == null) return true;
        boolean res = help(node.next);
        res = res && (node.val == left.val);
        left = left.next;
        return res;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode p1 = prev;
        ListNode p2 = (fast==null) ? slow : slow.next;
        while(p1!=null && p2!=null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}

