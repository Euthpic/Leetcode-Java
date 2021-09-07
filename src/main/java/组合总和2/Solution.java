package 组合总和2;

import java.util.*;

/**
 * 和上一题的两个区别: 1.数组元素可能重复  2.结果不能使用数组的同一个元素多次,也就是子节点不能使用父节点的元素
 * 区别在于多了两种情况需要剪枝
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> path=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        //有序才能剪枝
        Arrays.sort(candidates);
        int len=candidates.length;
        dfs(candidates,target,0,len,path,res);
        return res;
    }

    void dfs(int[] candidates, int target,int begin,int len,Deque<Integer> path,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <len ; i++) {
            if(target-candidates[i]<0){
                break;
            }
            //由于数组元素可能重复,这里要把与前继节点元素相同的节点剪掉
            if(i>begin&& candidates[i]==candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            //这里的i是指父节点元素在数组的位置,i+1表示子节点从该位置后一位开始遍历,保证不与父节点重复取值
            dfs(candidates,target-candidates[i],i+1,len,path,res);
            path.removeLast();
        }
    }
}
