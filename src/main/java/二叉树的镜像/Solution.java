package 二叉树的镜像;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(tmp);
        return root;
    }
      private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
