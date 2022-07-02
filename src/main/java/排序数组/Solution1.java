package 排序数组;
//插入排序
//从第一个元素出发,将其视为一个已排好序的数组,然后不断把右边第一个元素插入到有序数组中得到一个更大的数组.
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
