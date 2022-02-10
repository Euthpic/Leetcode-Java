package 组合;

/**
 * 在回溯中思考剪枝或者优化空间是比较好的习惯
 * 时间复杂度好像没法优化,因为从每个节点出发搜索的方向是任意的,不会和原先重复,也不存在长度不够的问题.
 * 我想到的唯一一种可以剪枝的情况是像贪吃蛇那样,已访问的位置围成一个闭环的圈,然后向圈内访问的同时圈内元素不够多.但这种情况好像很难判断.
 * 在空间上,原先的解法中,我们用了一个等大的矩阵visited来记录当前位置是否访问过,其实这个矩阵是可以避免的.
 * 如果当前位置已访问过就返回false,如果当前位置的字符不符合单词也返回false,二者等效.
 * 所以若一个位置已访问过,把它设置为一个"不可能等于原先矩阵所有元素"的值,这样就省略下这个访问矩阵了.
 * 回退时会还原这个操作,也不用担心影响后续操作.
 */
public class Solution2 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        int h = board.length;
        int w = board[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int i, int j, int k) {
        if (word.charAt(k) != board[i][j]) {
            return false;
        } else if (k == (word.length() - 1)) {
            return true;
        }
        board[i][j] += 256;
        //记住这个方向数组
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        //上下左右去找
        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            //下一个节点位于矩阵内
            if (newi >= 0 && newi <= board.length - 1 && newj >= 0 && newj <= board[0].length - 1) {
                boolean result = check(board, word, newi, newj, k + 1);
                if (result) {
                    return true;
                }
            }
        }
        //回退过程中还原当前操作
        board[i][j] -= 256;
        return false;
    }
}
