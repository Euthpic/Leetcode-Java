package 剑指offer.青蛙跳台阶;

public class Solution {
    public int numWays(int n) {
        if (n==0){
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int pre1=1;
        int pre2=2;
        int sum=pre1+pre2;
        for (int i = 3; i <= n; i++) {
            sum=(pre1+pre2)%1000000007;
            pre1=pre2;
            pre2=sum;
        }
        return sum;
    }
}
