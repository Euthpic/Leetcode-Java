package 不同路径2;

/**
 * 和上一题相比,差异在于加了路障,因此要加个判断,当(i,j)为路障时,f(i,j)=0
 * 原先的转移方程为f(i,j)=f(i-1,j)+(i,j-1),需要二维数组,这里用了滚动数组来优化成一维数组
 * 我们仅需保留一行的路径情况,定为f[j],同样由上一行和上一列的情况决定
 * 在列循环时(j++),当遍历到j时,f[0] ~f[j-1]的值都更新过了,前一列的情况可以表示为f[j-1],而f[j]及之后的值没有更新过,是上一行的情况,
 * 所以推导出f[j] =f[j] + f[j - 1]
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[] f=new int[m];
        //初始化起点
        if(obstacleGrid[0][0]==1){
            f[0]=0;
        }else{
            f[0]=1;
        }
        for (int[] arr : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (arr[j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j > 0 && arr[j] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m-1];
    }
}
