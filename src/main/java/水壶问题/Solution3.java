package 水壶问题;

//数学方法,贝祖定理
public class Solution3 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z <= 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        int gcd=GCD(x,y);
        return z%gcd==0;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return GCD(b, a % b);
    }
}
