package 剑指offer.重建二叉树;

import java.util.HashMap;
import java.util.Map;

public class Solution {

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
    int[] preorder;
    Map<Integer,Integer> dic=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        for (int i = 0; i <inorder.length ; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0, inorder.length-1);
    }

    public TreeNode recur(int preRoot,int inLeft,int inRight){
        if(inLeft>inRight) return null;
        int inRoot=dic.get(preorder[preRoot]);
        TreeNode treeNode=new TreeNode(preorder[preRoot]);
        treeNode.left=recur(preRoot+1,inLeft,inRoot-1);
        treeNode.right=recur(preRoot+inRoot-inLeft+1,inRoot+1,inRight);
        return treeNode;
    }
}
