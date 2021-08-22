package 在排序数组中查找元素的第一个和最后一个位置;

/**
 * 在一次遍历中同时找出左右边界的判定比较麻烦,所以改成两次遍历,通过isLower来区分是寻找左边界还是右边界
 * 左边界和右边界的区别在于:当target == nums[mid]的时候,是收敛左边界还是右边界.
 * 寻找左边界(第一个等于target的位置)时,当target == nums[mid]的时候,因为不关心右边界,所以收敛右边界
 * 寻找右边界(第一个大于target的位置-1)时,当target == nums[mid]的时候,因为不关心左边界,所以收敛左边界
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean isLower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid] || (isLower && target == nums[mid])) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
