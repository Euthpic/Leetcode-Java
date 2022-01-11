package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  1.把数组看成两部分,中间offset是即将要填入的位置,左边是已经填过的数字,右边是可选的数字,
 *    那么一直向右填数字就可以得到结果.问题就转化为如何维护这个数组.
 *  2.offset向右移(在回溯里面相当于往下一层)之前,依次交换第一个元素(first)和后面的元素(逐渐自增的i),那么在下一层看来这个数组还是满足1的条件
 *  3.回退到上一层之前把元素交换回来,那么可以保证上一层处理的都是同一个数组,只是要交换的下标(i)不同
 */
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

