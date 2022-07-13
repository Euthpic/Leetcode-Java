package 不同的二叉搜索树2;

import java.util.LinkedList;
import java.util.List;

/**
 * 关键词: 递归
 * 递归获取左右子树的可行集合,然后可行左子树任选一颗,可行右子树任选一颗,和根节点组成完整二叉搜索树
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            //add null容易漏掉,如果直接返回一个空list,下面遍历左子树就不会进行
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
