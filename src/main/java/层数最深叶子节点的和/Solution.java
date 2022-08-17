package 层数最深叶子节点的和;

import java.util.HashMap;
import java.util.Map;

/**
 * 用map维护最后一层的节点值总和
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int maxLevel = -1;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return map.getOrDefault(maxLevel, 0);
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level >= maxLevel) {
            maxLevel = level;
            map.put(maxLevel, map.getOrDefault(maxLevel, 0) + node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
