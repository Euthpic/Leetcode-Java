import java.util.*;

/**
 * 重复练习
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int pre = 0;
        int next = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (pre + next) % 1000000007;
            pre = next;
            next = sum;
        }
        return sum;
    }
}
