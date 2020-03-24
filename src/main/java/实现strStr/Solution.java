package 实现strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (isMatch(haystack.substring(i,i+needle.length()),needle)){
                return i;
            }
        }
        return -1;
    }

    private boolean isMatch(String str, String pattern) {
        return str.equals(pattern);
    }
}
