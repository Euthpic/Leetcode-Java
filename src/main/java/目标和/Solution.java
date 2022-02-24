package 目标和;

import java.util.HashMap;
import java.util.Map;

/**
 * 区间化搜索
 * 在不同情况下,当遍历到某一个下标后,若前面的计算总和一样的话,他们的结果也是一样的.
 * 也就是我们可以用一个map缓存结果,供下标及累计和都相同的情况复用.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    Map<String, Integer> cache = new HashMap<>();

    private int dfs(int[] nums, int target, int total, int offset) {
        String key = total + "_" + offset;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (offset == nums.length) {
            int res = target == total ? 1 : 0;
            cache.put(key, res);
            return res;
        }
        int left = dfs(nums, target, total + nums[offset], offset + 1);
        int right = dfs(nums, target, total - nums[offset], offset + 1);
        cache.put(key, left + right);
        return left + right;
    }
}
