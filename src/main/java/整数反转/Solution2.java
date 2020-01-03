package 整数反转;


public class Solution2 {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10
                    || (rev == Integer.MAX_VALUE / 10 && pop > 7)
                    || (rev < Integer.MIN_VALUE / 10)
                    || (rev == Integer.MIN_VALUE / 10 && pop < -8)
            ) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int result = solution.reverse(Integer.MAX_VALUE);
        System.out.println(result);

    }

}
