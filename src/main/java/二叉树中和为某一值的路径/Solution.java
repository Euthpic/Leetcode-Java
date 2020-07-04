package 二叉树中和为某一值的路径;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;

        if (root.left == null && root.right == null&&tar == 0) {
                res.add(new LinkedList<>(path));
        }
        dfs(root.left, tar);
        dfs(root.right, tar);
        path.removeLast();
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
