package 验证二叉搜索树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 中序遍历,得到的一定是升序序列,若上个遍历到的节点值大于本节点值则立刻返回false
 */
public class Solution {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        double inorder=-Double.MAX_VALUE;
        while (!deque.isEmpty()||root!=null){
            while (root!=null){
                deque.push(root);
                root=root.left;
            }
            root=deque.pop();
            if(root.val<=inorder){
                return false;
            }
            inorder=root.val;
            root=root.right;
        }
        return true;
    }

}
