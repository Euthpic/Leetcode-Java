package 电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> result = combine(null, chars[0]);
        for (int i = 1; i < chars.length; i++) {
            result = combine(result, chars[i]);
        }
        return result;
    }

    private List<String> combine(List<String> former, char number) {
        List<String> result = new ArrayList<>();
        String str = map.get(number);
        char[] chars = str.toCharArray();
        if (former == null) {
            for (char c : chars) {
                result.add(String.valueOf(c));
            }
        } else {
            for (String s : former) {
                for (char c : chars) {
                    result.add(s + c);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("234"));
    }
}
