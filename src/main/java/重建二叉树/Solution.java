package 重建二叉树;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return rebuild(0, 0, preorder.length - 1);
    }

    private TreeNode rebuild(int pre_root_index, int in_left_index, int in_right_index) {
        if (in_left_index > in_right_index) {
            return null;
        }
        int root_index = map.get(preorder[pre_root_index]);
        TreeNode root = new TreeNode(preorder[pre_root_index]);
        root.left = rebuild(pre_root_index + 1, in_left_index, root_index - 1);
        root.right = rebuild(pre_root_index + 1 + root_index - in_left_index, root_index + 1, in_right_index);
        return root;
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
