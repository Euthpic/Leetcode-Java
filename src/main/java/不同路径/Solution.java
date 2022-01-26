package 不同路径;

/**
 * 因为存在路径依赖,上一步怎么走会影响下一步,所以很容易想到动态规划
 * 定义f(i,j)为到达(i,j)的不同路径数
 * 要到达(i,j),要么从(i-1,j)向下走,要么从(i,j-1)向右走,
 * 所以转移方程f(i,j)=f(i-1,j)+(i,j-1)
 * 这里要注意的是i和j都要>0
 * 当i=0时,也就是一直往右走,只有一种走法,所以易得f(0,x)=1,同理f(y,0)=1
 * 当i和j都为0时,也就是从左上角到左上角,也是只有一种走法,f(0,0)=0
 * 这样我们在计算方程的时候就可以从i=1,j=1开始了
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
