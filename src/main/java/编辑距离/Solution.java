package 编辑距离;

/**
 *  将字符串A转换成字符串B可以有6种操作,插入A,插入B,删除A,删除B,替换A,替换B
 *  6种操作可以简化成3种,因为对A进行一个操作相当于对B进行一个反操作,插入A=删除B,替换A=替换B
 *  所以只剩下插入A,插入B,替换A三种操作.
 *  如果将插入B替换成删除A,相当于固定了字符串B,只操作A.但是这样的做法不好,dp转移方程中dp[i][j]就要依赖dp[i+1][j]了.
 *  用dp[i][j]表示A的前i个字符与B的前j个字符的编辑距离.
 *  于是dp[i-1][j]表示A去掉最后一个字符后与B的距离,那么A再插入最后一个字符就可以转换成A,此时dp[i][j]=dp[i-1][j]+1
 *  同样可得dp[i][j]=dp[i][j-1]+1,对应的最后一步操作是插入B
 *  对于dp[i-1][j-1],如果A和B的最后一个字符与B相同,那么最后不用操作,如果不同,最后要将A的最后一个字符替换成B的最后一个字符
 *  于是当最后字符相同时dp[i][j]=dp[i-1][j-1],否则dp[i][j]=dp[i-1][j-1]+1
 *  当i=0或者j=0,表示其中一个字符串是空串,易得dp[i][0]=i,dp[0][j]=j
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {
            return n+m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int insertA = dp[i - 1][j] + 1;
                int insertB = dp[i][j - 1] + 1;
                int replaceA = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replaceA += 1;
                }
                dp[i][j] = Math.min(insertA, Math.min(insertB,replaceA));
            }
        }
        return dp[n][m];
    }
}
