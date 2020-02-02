package 字符串转换整数;

public class Solution {

    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int result = 0;
        boolean symbol = false;
        boolean isEmpty = true;
        for (char c : str.toCharArray()) {
            if (!isEmpty) {
                if (c >= '0' && c <= '9') {
                    int num = symbol ? '0' - c : c - '0';
                    if (result > Integer.MAX_VALUE / 10
                            || (result == Integer.MAX_VALUE / 10 && num > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    if (result < Integer.MIN_VALUE / 10 ||
                            (result == Integer.MIN_VALUE / 10 && num < -8)) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 + num;
                } else {
                    break;
                }
            } else {
                if (c != ' ') {
                    isEmpty = false;
                }
                if (c == '-') {
                    symbol = true;
                } else if (c >= '0' && c <= '9') {
                    int num = c - '0';
                    result = result * 10 + num;
                } else if (c != ' ' && c != '+') {
                    return 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "-+3.14157";
        Solution solution = new Solution();
        int result = solution.myAtoi(s);
        System.out.println(result);
    }
}
