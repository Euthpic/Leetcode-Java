package 二维数组中的查找;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        if (target < matrix[0][0]) {
            return false;
        }

        int i = 0;
        int j = matrix[0].length-1;
        while (i <= matrix.length-1 && j >= 0 ) {
            int num = matrix[i][j];
            if (num == target) {
                return true;
            } else if (num > target) {
                j--;
            } else if (num < target) {
                i++;
            }
        }

        return false;
    }
}
