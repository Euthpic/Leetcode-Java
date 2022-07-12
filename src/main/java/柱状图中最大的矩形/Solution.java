package 柱状图中最大的矩形;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 关键词:单调栈,哨兵
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int len = heights.length + 2;
        int res = 0;
        int[] newHeight = new int[len];
        System.arraycopy(heights, 0, newHeight, 1, len - 2);
        newHeight[0] = 0;
        newHeight[len - 1] = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        for (int i = 1; i < len; i++) {
            while (newHeight[i] < newHeight[deque.peekLast()]) {
                int curHeight = newHeight[deque.pollLast()];
                int curWeight = i - 1 - deque.peekLast();
                res = Math.max(res, curHeight * curWeight);
            }
            deque.add(i);
        }
        return res;
    }
}
