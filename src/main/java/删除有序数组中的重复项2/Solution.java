package 删除有序数组中的重复项2;

/**
 * 快慢指针.
 * 快指针用于遍历原先的数组及判断当前位置是否已重复(num == nums[i - 2])
 * 慢指针用于重建新数组.
 * 当快指针遍历到非重复的元素,那么该元素加入到慢指针的数组,慢指针向后移.
 * 当快指针遍历到重复的元素时,慢指针跳过,啥也不做
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num != nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}
