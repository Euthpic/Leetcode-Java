package 从上到下打印二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        List<Integer> list=new LinkedList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
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
