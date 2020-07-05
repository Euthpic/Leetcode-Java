package 字符串的排列;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    List<String> res = new LinkedList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();

        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int num) {
        if (num == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = num; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(i, num);
            dfs(num + 1);
            swap(i, num);
        }
    }

    private void swap(int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
