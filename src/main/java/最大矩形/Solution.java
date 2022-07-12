package 最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 遍历二维矩阵,统计出每个元素左边连续1的个数(包括自身),得到一个新的二维矩阵
 * 新的二维矩阵的每一行,都可以构造出一个heights数组,heights[i]表示以该元素为右下角能构造出的最大矩形
 * 逐行将heights数组传给84题的函数,最大值即为所求.
 * 这题有点抽象,构造出来的二维矩阵画图容易明白些.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }


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
