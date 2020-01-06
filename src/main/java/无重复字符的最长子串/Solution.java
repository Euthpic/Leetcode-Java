package 无重复字符的最长子串;


import java.util.HashSet;



public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 1;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    result = Math.max(result, set.size());
                    set.clear();
                    break;
                } else {
                    set.add(s.charAt(j));
                    if (j == s.length() - 1) {
                        result = Math.max(result, set.size());
                        set.clear();
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("jbpnbwwd"));
    }
}
