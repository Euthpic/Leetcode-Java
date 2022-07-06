package 括号的最大嵌套深度;

public class Solution {
    public int maxDepth(String s) {
        int size = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')') {
                continue;
            }
            if (size == 0 || c == '(') {
                size++;
                max = Math.max(max, size);
                continue;
            }
            size--;
            max = Math.max(max, size);
        }
        return max;
    }
}
