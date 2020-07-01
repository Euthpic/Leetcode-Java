package 调整数组顺序使奇数位于偶数前面;

public class Solution {
    private int[] nums;

    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        this.nums = nums;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i<j&&(nums[i]&1)==1){
                i++;
            }
            while (i<j&&(nums[j]&1)==0){
               j--;
            }
            swap(i, j);
        }
        return nums;
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
