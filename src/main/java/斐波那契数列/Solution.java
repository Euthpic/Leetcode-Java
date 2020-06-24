package 斐波那契数列;

public class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre1=0;
        int pre2=1;
        int next=pre1+pre2;
        for (int i = 2; i <= n; i++) {
             next=(pre1+pre2)%1000000007;
            pre1=pre2;
            pre2=next;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.fib(4));
    }
}
