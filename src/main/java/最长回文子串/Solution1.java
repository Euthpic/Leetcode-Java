package 最长回文子串;

/**
 * 暴力法
 */
public class Solution1 {
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
        int len=sub.length();
        for (int i = 0; i < len/2; i++) {
            if (sub.charAt(i)!=sub.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       Solution1 solution=new Solution1();
        System.out.println(solution.longestPalindrome(""));

    }
}
