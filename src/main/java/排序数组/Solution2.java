package 排序数组;
//归并排序
//使用分治,将数组拆分成左右区间,然后分别递归去排序左区间和右区间,最后再合并起来.
//当拆分的区间足够小时改用插入排序.
public class Solution2 {

    private static final int THRESHOLD=7;
    public int[] sortArray(int[] nums){
        int[] tmp=new int[nums.length];
        mergeSort(nums,0,nums.length-1,tmp);
        return nums;
    }

    private void mergeSort(int[] nums,int left,int right,int[] tmp){
        //如果区间长度小于阈值则改用插入排序
        if(right-left<=THRESHOLD){
            insertionSort(nums,left,right);
            return;
        }
        int mid=left+(right-left)/2;
        //排序左区间
        mergeSort(nums,left,mid,tmp);
        //排序右区间
        mergeSort(nums,mid+1,right,tmp);
        //如果两个区间已经有序则无需合并
        if(nums[mid]<=nums[mid+1]){
            return;
        }
        //合并两个有序数组
        mergeOfTwoSortedArray(nums,left,right,mid,tmp);
    }
    private void insertionSort(int[] nums,int left,int right){
        for (int i = left+1; i <=right ; i++) {
            int tmp=nums[i];
            int j=i;
            while (j>left && nums[j-1]>tmp){
                nums[j]=nums[--j];
            }
            nums[j]=tmp;
        }
    }

    private void mergeOfTwoSortedArray(int[] nums,int left,int right,int mid,int[] tmp){
        System.arraycopy(nums,left,tmp,left,right-left+1);
        int i=left;
        int j=mid+1;
        for (int k = left; k <=right ; k++) {
           if(i==mid+1){
               nums[k]=tmp[j];
               j++;
           }else if(j==right+1){
               nums[k]=tmp[i];
               i++;
           }else if(tmp[i]<=tmp[j]){
               nums[k]=tmp[i];
               i++;
           }else{
               nums[k]=tmp[j];
               j++;
           }
        }
    }
}
