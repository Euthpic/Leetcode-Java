package 搜索二维矩阵;

/**
 * 既然是二维,就进行两次二分查找.
 * 先是取第一列来二分,确定在哪一行.然后在该行上进行常规的二分查找.
 * 第一次二分有一些特别,因为要找的不是最终的target,而是最后一个不大于target的值.
 * 对于普通的二分,当target>mid时,我们是向右区间收敛,left=mid+1;当target<mid时,我们是向左区间收敛,right=mid-1;
 * 这里之所以left和right都跳过了mid的位置是因为当mid==target时,我们就直接返回mid了.当mid !=target的情况下,mid一定不是返回值
 * 但是在这个二分中,即便target>mid的情况下,我们任然可能返回的是mid(target在这一行后面的位置),所以left收敛后等于mid,不能跳过.
 * 中点的计算也值得注意,偶数数组的中点有两个,普通的二分随便取哪个都行
 * 但是在这个二分中,left收敛后等于mid,如果mid = (left + right) / 2,也就是取左边的中点,当left和right是相邻的两行,那么mid又会等于left,
 * 这样就会循环赋值,陷于死循环,所以mid = (left + right +1 ) / 2,要取右边的中点,继续循环的条件也只能是left<right,当left==right时跳出循环
 *
 * left+right可能会溢出,所以这样处理会好些mid = (right - left+1) / 2 +left
 * 如果第一次二分取的是最后一列,那么无法处理每一行元素个数不一的情况
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]) return false;
        int row = binarySearchRow(matrix, target);
        if (row < 0) {
            return false;
        }
        return binarySearch(matrix[row], target);
    }

    private int binarySearchRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = (left + right+1) / 2;
            if (target >= matrix[mid][0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean binarySearch(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[mid]) {
                return true;
            } else if (target < matrix[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
