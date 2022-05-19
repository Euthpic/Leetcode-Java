package 剑指offer.矩阵中的路径;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, words, col, row, 0)) return true;
            }
        }

        return false;
    }

    boolean dfs(char[][] board, char[] words, int col, int row, int k) {
        if (col >= board[0].length || row >= board.length
                || col < 0 || row < 0 || board[row][col] != words[k]
        ) return false;

        if (k == words.length - 1) {
            return true;
        }
        char tmp = board[row][col];
        board[row][col] = '/';
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            if (dfs(board, words, col + direction[0], row + direction[1], k + 1)) {
                return true;
            }
        }
        board[row][col] = tmp;
        return false;
    }
}
