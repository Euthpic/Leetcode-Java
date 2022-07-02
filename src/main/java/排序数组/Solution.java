package 排序数组;

//选择排序
//遍历N趟,每趟把第N小的元素挪到第N个位置.
public class Solution {

    public int[] sortArray(int[] nums) {

        for (int i = 0; i <nums.length-1 ; i++) {
            int minIndex=i;
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            swap(nums,i,minIndex);
        }
        return nums;
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
