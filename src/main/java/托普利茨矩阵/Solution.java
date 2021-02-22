package 托普利茨矩阵;

public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }

        int n=matrix.length;int m=matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <m ; j++) {
                if(matrix[i-1][j-1]!=matrix[i][j]){
                  return false;
                }
            }

        }
        return true;
    }
}
