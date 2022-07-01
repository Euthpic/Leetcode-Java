package 排序数组;
//插入排序
public class Solution1 {

    public int[] sortArray(int[] nums){
        for (int i = 1; i <nums.length ; i++) {
            int tmp=nums[i];
            int j=i;
            while (j>0 &&nums[j-1]>tmp){
                nums[j]=nums[--j];
            }
            nums[j]=tmp;
        }
        return nums;
    }
}
