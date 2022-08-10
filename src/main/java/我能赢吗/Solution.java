package 我能赢吗;

import java.util.HashMap;
import java.util.Map;

/**
 * 记忆化搜索,和一般搜索的区别在于每次搜索都会把结果存储起来.如本题就用map存储了选择了数字后是否必胜的情况
 */
public class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    private boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotals) {
        if (!memo.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                //当前的i未被选择过
                if (((usedNumbers >> i) & 1) == 0) {
                    //如果选择了这个数后超过了desiredTotal则获胜
                    if (i + 1 + currentTotals >= desiredTotal) {
                        res = true;
                        break;
                    }
                    //如果选择了这个数后导致对手必败
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotals+i+1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }


}
