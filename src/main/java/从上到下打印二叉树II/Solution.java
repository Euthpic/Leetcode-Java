package 从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> list = new LinkedList<>();
        Deque<Deque<TreeNode>> queue = new LinkedList<>();
        list.add(root);
        queue.add(list);

        while (!queue.isEmpty()) {
            Deque<TreeNode> level = queue.poll();
            list = new LinkedList<>();
            List<Integer> subRes = new ArrayList<>();
            res.add(subRes);
            while (!level.isEmpty()) {
                TreeNode node = level.poll();
                subRes.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            if (list.size()>0){
                queue.add(list);
            }
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
