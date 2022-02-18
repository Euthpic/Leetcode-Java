package 子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 * 对于数组的每个元素都有选择或者不选两条路径,因此可以确定回溯的遍历结构
 * 然后问题就剩下如何解决因数字重复导致路径重复的问题
 * 先对数组排序,这样可以利用相邻的数字判断当前是否重复数字
 * 对于两个相邻的重复数字,选择情况有四种,00,01,10,11
 * 不难想象,由01和10所构成的子集是重复的,我们可以选择跳过01所构成的子集
 * 也就是当前元素和前一个元素相同时,如果先前元素未选,那么不能选择当前元素
 */
public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, false, nums, subset, res);
        return res;
    }

    private void dfs(int cur, boolean preChosen, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        //已找到结果,返回
        if (cur == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        //当前元素不选
        dfs(cur + 1, false, nums, subset, res);
        //剪枝,如果当前元素和上一个元素相同,且上一个元素未选,那么当前元素也不能选.
        if (!preChosen && cur > 0 && nums[cur] == nums[cur - 1]) {
            return;
        }
        //选择当前元素
        subset.add(nums[cur]);
        //当前元素已选
        dfs(cur + 1, true, nums, subset, res);
        //回退过程中撤销本层的操作
        subset.remove(subset.size() - 1);
    }
}
