package 剑指offer.剪绳子I;

public class Solution {
    public int cuttingRope(int n) {
        return dp(n);
    }

    private int dp(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        if (n == 5) {
            return 6;
        }
        if (n == 6) {
            return 9;
        }
        return 3 * dp(n - 3);
    }
}
