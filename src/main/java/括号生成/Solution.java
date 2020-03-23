package 括号生成;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("(", n - 1);
        map.put(")", n);
        LinkedList<String> former = new LinkedList<>();
        former.offer("(");
        while (map.get("(") > 0||map.get(")") > 0){
            combine(former, map);
        }
        return former;
    }

    private void combine(LinkedList<String> former, HashMap<String, Integer> map) {
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < former.size(); i++) {
            String s = former.poll();
            String leftCombine = s + "(";
            String rightCombine = s + ")";
            if (map.get("(") > 0 && isValid(leftCombine)) {
                result.add(leftCombine);
                map.put("(",map.get("(")-1);
            }
            if (map.get(")") > 0 && isValid(rightCombine)) {
                result.add(rightCombine);
                map.put(")",map.get(")")-1);
            }
        }
        for (String s : result) {
            former.offer(s);
        }
    }

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
        return stack.isEmpty() || (isAllLeft(stack) && s.length() < 6);
    }

    private boolean isAllLeft(LinkedList<Character> stack) {
        for (Character character : stack) {
            if (character == ')') {
                return false;
            }
        }
        return true;
    }

    private boolean isMatched(char a, char b) {
        return a == '(' && b == ')';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
