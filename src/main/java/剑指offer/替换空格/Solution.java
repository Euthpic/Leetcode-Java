package 剑指offer.替换空格;

public class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[s.length() * 3];
        int cur = 0;
        for (char c : chars) {
            if (c == ' ') {
                newChars[cur++] = '%';
                newChars[cur++] = '2';
                newChars[cur++] = '0';
            } else {
                newChars[cur++] = c;
            }
        }
        return new String(newChars,0,cur);
    }
}
