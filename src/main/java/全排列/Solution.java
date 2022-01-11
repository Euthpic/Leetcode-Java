package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> output=Arrays.stream(nums).boxed().collect(Collectors.toList());
        backTrace(len,res,output,0);
        return res;
    }

    private void backTrace(int len, List<List<Integer>> res,List<Integer> output,int first){
        if(first==len){
            res.add(new ArrayList<>(output));
            return;
        }

        for (int i = first; i < len; i++) {
            Collections.swap(output,first,i);
            backTrace(len,res,output,first+1);
            Collections.swap(output,first,i);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
