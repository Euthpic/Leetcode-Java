package 搜索二维矩阵;

/**
 * 如果把二维矩阵拼接成一维数组,那么就可以仅进行一次二分查找.
 * 为了效率,不能用新的数组来实现,所以我们的方法是通过映射获取中点值,x = matrix[mid / n][mid % n]
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int x = matrix[mid / n][mid % n];
            if (target == x) {
                return true;
            } else if (target < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
