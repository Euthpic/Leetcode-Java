package 下一个排列;


import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int target = -1;
        //找出最小改动位
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                target = i - 1;
                break;
            }
        }
        //如果没有这样一位,说明已经是最大排序,因此返回最小排序
        if (target == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = nums.length - 1; i > target; i--) {
            if (nums[i] > nums[target]) {
                swap(nums, i, target);
                break;
            }
        }
        reverse(nums, target + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        System.out.println(nums);
    }

}
