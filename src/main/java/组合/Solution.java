package 组合;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 比较经典的回溯
 * 这里有一个可以剪枝的点:当数组剩下的数不够选的时候可以剪掉
 * 可以归纳出 : 搜索起点的右边界+剩下要选的元素个数-1 = n
 * 剩下要选的元素个数= k-path.size()
 * 所以搜索起点的右边界=n- (k-path.size)+1
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <=n ; i++) {
            path.add(i);
            dfs(n,k,i+1,path,res);
            path.removeLast();
        }
    }
}
