package 单词搜索;

/**
 * 回溯,遍历矩阵的每个节点,然后上下左右去找剩下的单词是否匹配.
 * 使用了一个等大的visited矩阵来标记当前位置是否访问过,防止在一次搜索中节点重复使用
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, boolean[][] visited, int i, int j, int k) {
        if (word.charAt(k) != board[i][j]) {
            return false;
        } else if (k == (word.length() - 1)) {
            return true;
        }
        visited[i][j] = true;
        //记住这个方向数组
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        //上下左右去找
        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            //下一个节点位于矩阵内并且没有访问过
            if (newi >= 0 && newi <= board.length - 1 && newj >= 0 && newj <= board[0].length - 1 && !visited[newi][newj]) {
                boolean result = check(board, word, visited, newi, newj, k + 1);
                if (result) {
                    return true;
                }
            }
        }
        //回退过程中还原当前操作
        visited[i][j] = false;
        return false;
    }
}
