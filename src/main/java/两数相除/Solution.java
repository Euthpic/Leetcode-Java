package 两数相除;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        boolean flag = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int count=0;
        while (dividend >= divisor) {
            dividend-=divisor;
            count++;
        }
        return flag ?-count:count ;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.divide(2147483647,2));
    }
}
