package 从上到下打印二叉树III;

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
        int flag=-1;
        while (!queue.isEmpty()) {
            Deque<TreeNode> level = queue.poll();
            list = new LinkedList<>();
            LinkedList<Integer> subRes = new LinkedList<>();
            res.add(subRes);
            while (!level.isEmpty()) {
                TreeNode node = level.poll();
                if (flag>0){
                    subRes.addFirst(node.val);
                }else {
                    subRes.addLast(node.val);
                }
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
            }
            flag=-flag;
            if (list.size() > 0) {
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
