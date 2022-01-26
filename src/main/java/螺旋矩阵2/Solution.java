package 螺旋矩阵2;

/**
 * 跟螺旋矩阵1一样按层模拟逐个打印.
 * 之前的算法中有个特殊判断,向左或向上模拟的时候,如果left=right或者top==bottom的时候就跳过,但是我觉得这样的表达不够简单直接
 * 这次按照遍历的个数来控制中断,一个n*m的矩阵,当遍历的格子数> n*m就直接中断,这样结构上更加简单清晰
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};
        int[][] res = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int num = 1;
        while (num <= n * n) {
            //向右
            for (int column = left; column <= right; column++) {
                res[top][column] = num;
                num++;
            }
            //向下
            for (int row = top + 1; row <= bottom; row++) {
                res[row][right] = num;
                num++;
            }
            //打印的个数够了就中断
            if (num > n * n) {
                break;
            }
            //向左
            for (int column = right - 1; column >= left; column--) {
                res[bottom][column] = num;
                num++;
            }
            //向上
            for (int row = bottom - 1; row > top; row--) {
                res[row][left] = num;
                num++;
            }
            //往内层收缩
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
