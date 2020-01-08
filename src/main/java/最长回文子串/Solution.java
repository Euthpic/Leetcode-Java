package 最长回文子串;

/**
 * 暴力法
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindromic(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        if (result.equals("")){
            return s.substring(0,1);
        }
        return result;
    }

    public boolean isPalindromic(String sub) {
        if (sub == null || sub.length() == 0) {
            return false;
        }
        int begin = 0;
        int end = sub.length() - 1;
        while (begin <= end) {
            if (sub.charAt(begin++) != sub.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       Solution solution=new Solution();
        System.out.println(solution.longestPalindrome(""));

    }
}
