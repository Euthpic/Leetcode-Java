package 最后一个单词的长度;

//求最后一个单词也就是求反向遍历的第一个单词
//一开始看错题目,以为是求最长单词的长度,如果是这样可以用双指针来实现
public class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end--;
        }
        int len = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            len++;
            end--;
        }
        return len;
    }
}
