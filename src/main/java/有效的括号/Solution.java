package 有效的括号;

import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.getFirst();
                if (isMatched(top, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatched(char a, char b) {
        boolean case1 = a == '(' && b == ')';
        boolean case2 = a == '[' && b == ']';
        boolean case3 = a == '{' && b == '}';
        return case1 || case2 || case3;
    }
}
