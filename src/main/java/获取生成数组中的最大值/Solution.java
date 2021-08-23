package 获取生成数组中的最大值;

import java.util.Arrays;

/**
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 *
 * 感觉这题只是在考数组越界,对于长度为n+1的数组而言,arr[2*n+1]会越界,然后需要对n进行等式转换,就像高中的函数符号替代
 */
public class Solution {
    public int getMaximumGenerated(int n) {
        if(n<2){
            return n;
        }
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <=n ; i++) {
           if(i%2==0){
            arr[i]=arr[i/2];
           }else{
               arr[i] = arr[(i-1)/2]+arr[(i+1)/2];
           }
        }
        return Arrays.stream(arr).max().getAsInt();
    }
}
