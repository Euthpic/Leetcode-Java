package 删除排序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i]==nums[j]){
              continue;
            }
            nums[++i]=nums[j];
        }
        return i+1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,1,2,3,5,5,7};
        System.out.println(solution.removeDuplicates(nums));
    }
}
