package 不同的二叉搜索树;


/**
 * 定义两个函数：
 * <p>
 * G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
 * <p>
 * F(i, n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数(1≤i≤n)。
 * 显然G(n)=从1到n累加F(i,n)
 * F(3,7)表示以3为根节点,序列[2,4]为左子树,可表示为G(2),序列[4,5,6,7]为右子树,可表示为G(4).
 * 可见G(n)与区间具体的元素无关,只与区间长度有关.
 * 于是推导出F(i,n)=G(i-1)* G(n-i)
 * G(0)=1表示空树,G(1)=1表示只有一个根节点
 * 那么F(i,n)与G(n)的关系就可以推导出来了
 */
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

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}

