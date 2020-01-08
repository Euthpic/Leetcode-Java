package 两数之和;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = i;
                result[1] = map.get(complement);
                if (result[0] == result[1]) {
                    continue;
                }

                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4,};
        int target = 6;
        Solution solution = new Solution();
        int result[] = solution.twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
