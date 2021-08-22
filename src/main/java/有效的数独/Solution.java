package 有效的数独;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 使用三个set数组来存放该行,该列以及子数独的数字出现情况
 * 关键点在于如何划分子数独
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] columns = new HashSet[9];
        Set<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int box = (i / 3) * 3 + j / 3;
                if (rows[num].contains(i) || columns[num].contains(j) || boxes[num].contains(box)) {
                    return false;
                }
                rows[num].add(i);
                columns[num].add(j);
                boxes[num].add(box);
            }
        }
        return true;
    }
}
