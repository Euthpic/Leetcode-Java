package 等差子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res=new ArrayList<>();
        for (int i = 0; i <l.length ; i++) {
            res.add(isArithmeticSubarrays(Arrays.copyOfRange(nums,l[i],r[i])));
        }
        return res;
    }

    private Boolean isArithmeticSubarrays(int[] arr){
        if (arr.length<=2){
            return true;
        }
        Arrays.sort(arr);
        int gap=arr[1]-arr[0];
        for (int i = 1; i < arr.length; i++) {
            int sub=arr[i]-arr[i-1];
            if (gap!=sub){
                return false;
            }
        }
        return true;
    }
}
