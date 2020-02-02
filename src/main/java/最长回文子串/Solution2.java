package 最长回文子串;

// 动态规划
public class Solution2 {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        String maxStr = "";
        int maxLen = 0;
        //外层遍历数组长度
        for (int len = 1; len <= length; len++) {
            //内层遍历字符串的开头
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    //字符串溢出
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1])
                        && s.charAt(start) == s.charAt(end);
                if (P[start][end] && len > maxLen) {
                    maxStr = s.substring(start, end + 1);
                    maxLen = len;
                }
            }
        }
        return maxStr;
    }
}
