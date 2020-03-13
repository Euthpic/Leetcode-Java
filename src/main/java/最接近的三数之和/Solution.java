package 最接近的三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2]-target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right] - target;
                result = Math.abs(result) < Math.abs(sum) ? result : sum;
                if (sum < 0) {
                    left++;
                }
                if (sum > 0) {
                    right--;
                }
                if (sum == 0) {
                    return target;
                }
            }
        }
        return result + target;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}
