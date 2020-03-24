package 移除元素;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == val && nums[j] == val) {
                continue;
            } else if (nums[i] == val && nums[j] != val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,1,2};
        int val=1;
        System.out.println(solution.removeElement(nums,val));
    }
}
