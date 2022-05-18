package 剑指offer.重建二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树的题基本都是用递归解决,左子树递归获取,右子树递归获取,结构就确定下来了 left=recur(x,y)
 * 接下来的问题变成递归里面的参数是什么,也就是下一层的什么参数可以从上一层推导出来.
 * 一棵树比较重要的属性是根节点,左边界,右边界的位置,因此我们要研究如何推导它们.
 * 前序遍历的序列是[根节点,左子树,右子树],中序遍历的序列是[左子树,根节点,右子树]
 * 可以看到前序的第一个元素是根节点,因此遍历可以从这里出发,也确定了其中一个参数是前序根节点位置,记为preRoot
 * 由于不含重复元素,因此通过前序根节点的值可以找出中序根节点的位置,记为inRoot,这里通过hashmap实现.
 * 有了inRoot,左子树在中序的左右边界就可以推导出来了,左边界为这棵树的左边界,可以递归传下来,记为inLeft,初始0
 * 左子树的右边界与根节点相邻,为inRoot-1
 * 左子树的根节点在中序中不好确定,而在前序中很容易表示为preRoot+1
 * 右子树的左边界与根节点相邻,为inRoot+1
 * 右子树的右边界为树的右边界,同样递归传下来,记为inRight
 * 右子树的根节点同样在前序中较好确定,=根节点+左子树长度,而左子树长度=左子树右边界-左子树根节点+1,所以最终=preRoot+inRoot-inLeft+1 (这里很容易因为边界推导出错)
 * 这样左右子树的根节点,左右边界就推导出来了,需要的参数为[前序的根节点位置preRoot,中序的左边界inLeft,中序的右边界inRight]
 * 左子树根节点,左右边界依次表示为: [preRoot+1,inLeft,inRoot-1]
 * 右子树根节点,左右边界依次表示为: [preRoot+inRoot-inLeft+1,inRoot+1,inRight]
 */
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
