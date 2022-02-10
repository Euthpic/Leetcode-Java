package 子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题主要考察位运算
 * 设数组nums的长度为n,那么推导出子集的个数为2^n - 1是解题关键
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            subset.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(subset));
        }
        return res;
    }
}
