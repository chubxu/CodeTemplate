package org.chubxu.algorithm.leetcode.qn016;

import org.chubxu.algorithm.leetcode.ListNode;

/**
 * @ClassName Lt1669
 * @Description
 *
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 *
 * 请你返回结果链表的头指针。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * 示例 2：
 *
 *
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 *
 *
 * 提示：
 *
 * 3 <= list1.length <= 104
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 104
 *
 * @Since 1.0.0
 * @Date 2023/1/30 22:36
 * @Author chubxu
 */
public class Lt1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode(-1, list1);
        ListNode currentNode = dummyNode;
        for (int i = 0; i < a; i++) {
            currentNode = currentNode.next;
        }
        ListNode aLastNode = currentNode;
        for (int i = 0; i < (b - a + 1); i++) {
            currentNode = currentNode.next;
        }
        ListNode bNode = currentNode;
        aLastNode.next = list2;
        while(list2.next!=null) {
            list2 = list2.next;
        }
        list2.next = bNode.next;
        bNode.next = null;
        return dummyNode.next;
    }
}
