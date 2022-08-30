package 最大二叉树2;

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        TreeNode prev=null;
        TreeNode cur=root;
        //遍历右子树,直至找到节点值小于val的
        while (cur!=null&&cur.val>val){
            prev=cur;
            cur=cur.right;
        }
        //也就是val大于原先树中所有的元素
        if(prev==null){
            node.left=root;
            return node;
        }else{
            prev.right=node;
            node.left=cur;
            return root;
        }
    }
}
