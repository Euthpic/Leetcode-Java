package 数组中出现次数超过一半的数字;

public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (vote == 0) {
                res = nums[i];
            }
            if (nums[i] == res) {
                vote++;
            } else {
                vote--;
            }
        }
        return res;
    }
}
