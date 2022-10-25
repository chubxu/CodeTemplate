package org.chubxu.algorithm.leetcode;

/**
 * @ClassName ListNode
 * @Description 通用类
 * @Since 1.0.0
 * @Date 2022/10/25 22:49
 * @Author chubxu
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
