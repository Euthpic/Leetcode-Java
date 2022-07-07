package 腐烂的橘子;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int count = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    count--;
                    queue.add(new int[]{row - 1, col});
                }
                if (row + 1 < M && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new int[]{row + 1, col});
                    count--;

                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new int[]{row, col - 1});
                    count--;
                }
                if (col + 1 < N && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new int[]{row, col + 1});
                    count--;
                }
            }

        }
        if (count > 0) {
            return -1;
        }
        return round;
    }
}
