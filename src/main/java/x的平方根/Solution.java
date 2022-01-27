package x的平方根;

/**
 * 二分法
 * 这里要注意的是平方根是舍掉小数部分的整数,因此存在res*res<=x的情况
 */
public class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;

        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return res;
    }
}
