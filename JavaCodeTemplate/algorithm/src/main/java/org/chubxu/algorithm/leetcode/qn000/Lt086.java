package org.chubxu.algorithm.leetcode.qn000;

import org.chubxu.algorithm.leetcode.ListNode;

/**
 * @ClassName Lt086
 * @Description
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Since 1.0.0
 * @Date 2022/10/25 23:22
 * @Author chubxu
 */
public class Lt086 {
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode();
        ListNode cs = s;
        ListNode b = new ListNode();
        ListNode cb = b;
        while (head != null) {
            if (head.val < x) {
                cs.next = head;
                cs = cs.next;
            } else {
                cb.next = head;
                cb = cb.next;
            }
            head = head.next;
        }
        cb.next = null;
        cs.next = b.next;
        return s.next;
    }
}
