package 四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 3; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            for (int i = j + 1; i < nums.length - 2; i++) {
                if (i > j + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[j] + nums[i] + nums[left] + nums[right] - target;
                    if (sum < 0) {
                        left++;
                    }
                    if (sum > 0) {
                        right--;
                    }
                    if (sum == 0) {
                        result.add(List.of(nums[j], nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        System.out.println(solution.fourSum(nums, -11));
    }
}