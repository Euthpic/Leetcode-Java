package 机器人的运动范围;

public class Solution {
    int m;
    int n;
    int k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= m
                || j < 0 || j >= n
                || !permit(i, j)
                || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);

    }

    private boolean permit(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }
}
