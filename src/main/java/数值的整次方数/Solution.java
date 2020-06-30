package 数值的整次方数;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || x == 0) {
            return x;
        }
        double res = 1.0;
        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp=-exp;
        }
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res *= x;
            }
            x *= x;
            exp >>= 1;
        }

        return res;
    }

}
