package 合并区间;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 1.区间是否重叠和区间的左右端点的位置有关,因此先按左端点进行排序会方便处理很多,可以省略判断哪个在左哪个在右.
 * 2.排序后,假设有两个相邻区间a(l1,r1),b(l2,r2),那么会有l1<=l2.
 * 3.只有当r1<l2的时候它们才会不重叠,根据这个就可以判断是否需要合并区间.
 * 4.合并后的区间左端点一定是l1,右端点取r1和r2之间的较大值
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(r, merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
