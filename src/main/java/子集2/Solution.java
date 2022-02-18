package 子集2;

import java.util.*;

/**
 * 相比之前的题,区别在于数组的数字是可以重复的
 * 比如数组[1,2,2],继续用位运算的话,001和010表示的子集都是[2],会重复,这种情况要跳过
 * 我们另外用一个set存储已经统计过的子集,发现重复时就跳过
 * 对数组去重时,先排序会方便后续操作
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Set<String> values=new HashSet<>();
        for (int i = 0; i < 1<<n  ; i++) {
            subset.clear();
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                    sb.append(nums[j]);
                }
            }
            if(!values.contains(sb.toString())){
                res.add(new ArrayList<>(subset));
                values.add(sb.toString());
            }

        }
        return res;
    }
}
