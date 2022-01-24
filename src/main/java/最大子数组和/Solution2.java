package 最大子数组和;

public class Solution2 {

    //动态规划
    public int maxSubArray(int[] nums) {
        int pre=0;
        int max=nums[0];
        for (int num : nums) {
            pre=Math.max(num,pre+num);
            max=Math.max(pre,max);
        }
        return max;
    }
}
