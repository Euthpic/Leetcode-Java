package 替换空格;

public class Solution {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                result.append(ch);
            } else {
                result.append("%20");
            }
        }
        return result.toString();
    }
}
