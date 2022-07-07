package 最长连续递增序列;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 1;
        int max = 1;
        int tmp = 1;
        while (j < nums.length) {
            if (nums[j - 1] >= nums[j]) {
                max = Math.max(max, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
            j++;
        }
        max = Math.max(max, tmp);
        return max;
    }
}
