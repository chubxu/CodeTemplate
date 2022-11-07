package org.chubxu.algorithm.leetcode.qn002;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @ClassName Lt297
 * @Description
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 *
 * @Since 1.0.0
 * @Date 2022/11/7 23:14
 * @Author chubxu
 */
public class Lt297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    public void serialize(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#").append(",");
            return ;
        }
        sb.append(node.val).append(",");
        serialize(sb, node.left);
        serialize(sb, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        LinkedList<String> list = new LinkedList<>();
        String[] split = data.split(",");
        for (String s : split) {
            list.add(s);
        }
        return deserialize(list);
    }

    public TreeNode deserialize(LinkedList<String> list) {
        String s = list.removeFirst();
        if (Objects.equals(s, "#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
