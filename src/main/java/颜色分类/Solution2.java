package 颜色分类;

/**
 * 基于双指针的选择排序
 * 用p0和p1两个指针来标记0和1尾部的位置
 * 交换p1和当前位置比较简单,但是交换p0复杂一些,因为p1在p0后面,有可能把p0处的1交换出去.
 * 当p0<p1时,那么p0位置肯定是1,除了交换num[i]和p0之外,还得交换num[i]和p1,即把交换出去的1又交换回来
 * 交换了num[i]和p0之后,不管如何p0和p1的位置都要后移
 * 因为当p0=p1的时候,p0++,那么p1也要跟着++,p1不能小于p0
 * 当p0<p1的时候,也就是上面说的把1交换出去又交换回来,那么p1自然要后移.
 */
public class Solution2 {

    public void sortColors(int[] nums) {
        if (nums==null||nums.length==0){
            return;
        }
        int p0=0;
        int p1=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                int tmp=nums[i];
                nums[i]=nums[p1];
                nums[p1]=tmp;
                p1++;
            }else if(nums[i]==0){
                int tmp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=tmp;
                if(p0<p1){
                    tmp=nums[i];
                    nums[i]=nums[p1];
                    nums[p1]=tmp;
                }
                p0++;
                p1++;
            }
        }
    }
}
