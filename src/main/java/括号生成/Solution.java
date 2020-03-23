package 括号生成;

import java.util.*;

public class Solution {
    ArrayList<String> output = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrace("", n, n);
        return output;
    }

    private void backtrace(String pattern, int left, int right) {
        if (left == 0 && right == 0) {
            output.add(pattern);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            backtrace(pattern + "(", left - 1, right);
        }
        if (right > 0) {
            backtrace(pattern + ")", left, right - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
