package 剑指offer.机器人的运动范围;

public class Solution {
    private boolean[][] isVisited;
    public int movingCount(int m, int n, int k) {
        this.isVisited = new boolean[m][n];
        return dfs(m, n, 0, 0, k);
    }

    private int dfs(int m, int n, int row, int col, int k) {
        if (row >= m || col >= n || isVisited[row][col] || !isPermit(row, col, k)) {
            return 0;
        }
        isVisited[row][col]=true;
        return 1 + dfs(m, n, row + 1, col, k) + dfs(m, n, row, col + 1, k);
    }

    private boolean isPermit(int row, int col, int k) {
        int sum = row / 10 + row % 10 + col / 10 + col % 10;
        return sum <= k;
    }
}
