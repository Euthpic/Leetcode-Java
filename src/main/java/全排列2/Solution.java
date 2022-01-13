package 全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.使用标记数组标记数组中哪些元素使用过.数字可重复,但是排列不能重复,所以难点在于去重,如何判断出这次的排列和之前的已经重复.
 * 2. 去重表达式 if(flags[i]||(i>0 && nums[i]==nums[i-1] && !flags[i-1] ))
 * 3. if (当前元素已经使用过 或者 ( 当前元素与前一个元素相同,且前一个元素未使用过 ) 则表示重复,跳过.
 *   难理解的是 !flags[i-1].
 *   假设数组是[1,2,3,4],那么最终的序列其中两个会是[1,2,3,4]和[1,3,2,4],
 *   前一个序列的[3]排在[2]后面,也就是递归的下一层,[2]是已经被使用过了,也就是flags[i-1] == true.
 *   后一个序列的[3]排在[2]前面,[2]没被使用过,也就是flags[i-1] == false.
 *   现在把数组换成[1,2,2,4],用[2]去替换原来的[3],那么上面的[1,2,'3',4]和[1,'3',2,4]是重复的,只能选择其中一个.
 *   这里选择了前一个flags[i-1] == true ,所以flags[i-1]不能跳过,!flags[i-1]时要跳过.
 *   那么选择后面一种情况可以吗?答案是不行,因为后一种重复的数字是在树的同一层,每多一个重复数字就会多一个重复的序列.
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flags=new boolean[nums.length];
        backTrace(nums,res,output,flags,0);
        return res;

    }

    private void backTrace(int[] nums,List<List<Integer>> res,List<Integer> output,boolean[] flags,int index){
        if(nums.length==index){
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(flags[i]||(i>0 && nums[i]==nums[i-1] && !flags[i-1] )){
                continue;
            }
            flags[i]=true;
            output.add(nums[i]);
            backTrace(nums,res,output,flags,index+1);
            flags[i]=false;
            output.remove(index);
        }

    }
}
