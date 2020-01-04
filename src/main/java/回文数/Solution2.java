package 回文数;


public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0) {
            // 特殊情况,如果一个数既不是0,而且个位数为0,那么一定非回文数
            // 这种情况一定要处理,因为rev*10是一个进位的过程,个十百千万,
            // 如果x的个位为0会导致rev第一次*10的结果还是0,等于第一次没有进位
            return false;
        }
        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            if (rev == x) {
                return true;
            }
            x /= 10;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isPalindrome(10));
    }
}
