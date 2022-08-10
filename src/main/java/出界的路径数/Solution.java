package 出界的路径数;

/**
 * 记忆化搜索
 * 因为路径可能重复,因此搜索过程中使用cache来存储该次搜索结果,后续重复时直接复用
 * 在路径搜索中,directions数组是挺方便遍历的
 */
public class Solution {
    int MOD = (int) 1e9 + 7;
    int[][][] cache;
    int row;
    int col;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        row=m;
        col=n;
        cache=new int[m][n][maxMove+1];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k]=-1;
                }
            }
        }
        return dfs(startRow,startColumn,maxMove);
    }

    private int dfs(int x, int y, int k) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return 1;
        }
        if(k==0){
            return 0;
        }
        //路径有可能重复,所以这里通过cache来剪枝
        if (cache[x][y][k] != -1) {
            return cache[x][y][k];
        }
        int res = 0;
        for (int[] direction : directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            res += dfs(nextX, nextY, k - 1);
            res%=MOD;
        }
        cache[x][y][k]=res;
        return res;
    }
}
