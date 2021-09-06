package 组合总和;

import java.util.*;

/**
 * 1.回溯算法,有序才方便剪枝
 * 2.重要的是理解两种剪枝的情况
 * 每一条路径以0或者负数为叶子节点,如果为0,说明该路径符合要求,加入结果集然后返回;
 * 如果为负数,由于排序后同一层节点的元素递减(减去的元素递增),第一个节点即为最大节点,如果该节点为负数,则同层其余节点也为负数,可一起剪掉;
 * !!重要: 每个节点及其子树所构成的组合已经包括了该节点元素能构成的所有组合,如果同层其他路径上还包括该元素,则该路径必然与该节点组成的路径重复,需要剪掉.
 * 可以用窗口来理解这点
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            path.addLast(candidates[i]);
            dfs(candidates,target-candidates[i],i,len,path,res);
            path.removeLast();
        }
    }
}
