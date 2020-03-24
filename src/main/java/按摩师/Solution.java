package 按摩师;

public class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tp0 = Math.max(dp0, dp1);
            int tp1 = dp0 + num;

            dp0 = tp0;
            dp1 = tp1;
        }
        return Math.max(dp0, dp1);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,1};
        System.out.println(solution.massage(nums));
    }
}

