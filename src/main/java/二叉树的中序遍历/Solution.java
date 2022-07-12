package 二叉树的中序遍历;

import java.util.LinkedList;
import java.util.List;

//递归


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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            inorder(root,res);
        }
        return res;
    }

    private void inorder(TreeNode node,List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorder(node.left,res);
        }
        res.add(node.val);
        if (node.right != null) {
            inorder(node.right,res);
        }
    }
}
