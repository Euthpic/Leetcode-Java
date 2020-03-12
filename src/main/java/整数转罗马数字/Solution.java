package 整数转罗马数字;

import java.util.HashMap;

public class Solution {
    public String intToRoman(int num) {
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int location = 0;
        while (num > 0) {
            int count = num / nums[location];
            for (int i = 0; i < count; i++) {
                result.append(strings[location]);
            }
            num -= nums[location] * count;
            location++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
    }
}
