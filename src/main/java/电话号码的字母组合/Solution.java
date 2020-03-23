package 电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<String, String> phone = new HashMap<>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    ArrayList<String> output = new ArrayList<>();

    public void backtrack(String combination, String nextDigit) {
        if (nextDigit.length() == 0) {
            output.add(combination);
        } else {
            String num = nextDigit.substring(0, 1);
            String letters = phone.get(num);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigit.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234"));
    }
}
