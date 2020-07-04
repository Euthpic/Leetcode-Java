package 二叉搜索树的后序遍历序列;

public class Solution {
    private int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return recur(0, postorder.length - 1);
    }

    private boolean recur(int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(i, m - 1) && recur(m, j - 1);
    }
}
