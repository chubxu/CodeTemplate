package org.chubxu.algorithm.leetcode;

/**
 * @ClassName Node
 * @Description 基础类
 * @Since 1.0.0
 * @Date 2022/11/3 22:47
 * @Author chubxu
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
