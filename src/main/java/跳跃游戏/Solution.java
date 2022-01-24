package 跳跃游戏;

/**
 * 贪心,每走一步都维护一个最远距离.
 * 如果当前位置>之前的最远距离,则该位置不可达,跳跃中断
 * 当前位置能到的最远距离 = max(当前位置+当前格能跳的最大距离,之前的最远距离)
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;

        int far=0;
        for (int index = 0; index <nums.length ; index++) {
            if(index>far) return false;
            if(index+nums[index]>=nums.length-1) return true;
            far=Math.max(far,index+nums[index]);
        }
        return true;
    }
}
