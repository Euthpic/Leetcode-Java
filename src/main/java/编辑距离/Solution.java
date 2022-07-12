package 编辑距离;

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
