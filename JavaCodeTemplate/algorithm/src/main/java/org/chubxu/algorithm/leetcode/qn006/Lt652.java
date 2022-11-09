package org.chubxu.algorithm.leetcode.qn006;

import org.chubxu.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Lt652
 * @Description
 *
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 *
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 *
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 *
 *
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *
 *
 * 提示：
 *
 * 树中的结点数在 [1, 5000] 范围内。
 * -200 <= Node.val <= 200
 *
 * @Since 1.0.0
 * @Date 2022/11/8 22:18
 * @Author chubxu
 */
public class Lt652 {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        help(root);
        return res;
    }

    public String help(TreeNode node) {
        if (node == null) return "#";
        String leftString = help(node.left);
        String rightString = help(node.right);

        String str = leftString + "," + rightString + "," + node.val;
        if (map.containsKey(str)) {
            if (map.get(str) == 1) {
                res.add(node);
                map.put(str, map.get(str)+1);
            }
        } else {
            map.put(str, 1);
        }
        return str;
    }
}
