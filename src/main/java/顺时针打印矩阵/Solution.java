package 顺时针打印矩阵;

public class Solution {


    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int lenth = matrix[0].length * matrix.length;
        int[] res = new int[lenth];
        int index = 0;
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            if (index >= lenth) {
                break;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (index >= lenth) {
                break;
            }
            r--;
            for (int i = r; i >= l; i--) {
                res[index++] = matrix[b][i];
            }
            if (index >= lenth) {
                break;
            }
            b--;
            for (int i = b; i >= t; i--) {
                res[index++] = matrix[i][l];
            }
            if (index >= lenth) {
                break;
            }
            l++;
        }
        return res;
    }

}
