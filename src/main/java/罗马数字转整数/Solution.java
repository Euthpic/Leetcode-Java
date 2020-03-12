package 罗马数字转整数;

import java.util.HashMap;

public class Solution {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('V', 5);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        int i = s.length() - 2;
        while (i >= 0) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
            --i;
        }

        return result;
    }
}
