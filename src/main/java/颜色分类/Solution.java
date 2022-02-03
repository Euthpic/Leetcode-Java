package 颜色分类;

/**
 * 基于单指针的选择排序
 * 跟普通的选择排序相比,这里要排序的值是确定而且少量的
 * 所以我们可以一趟遍历把0先搬到最前面,然后再把1搬到0的后面.总共两趟遍历
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums==null||nums.length==0){
            return;
        }
        int ptr=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr]=tmp;
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if(nums[i]==1){
                int tmp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr]=tmp;
                ptr++;
            }
        }
    }
}
