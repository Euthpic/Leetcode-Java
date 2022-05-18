package 剑指offer.二维数组中的查找;

public class Sulution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col>=0) {
            //找到就返回
            if (target == matrix[row][col]) {
                return true;
            }else if (target < matrix[row][col]) {
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
