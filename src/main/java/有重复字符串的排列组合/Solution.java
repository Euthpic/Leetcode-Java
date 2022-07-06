package 有重复字符串的排列组合;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String[] permutation(String S) {
        if (null == S || S.length() == 0) {
            return new String[0];
        }
        char[] chars = S.toCharArray();
        Set<String> res = new HashSet<>();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1]) {
                continue;
            }
            boolean[] visited = new boolean[chars.length];
            char[] tmp = new char[chars.length];
            backTrace(res, tmp, i, visited, 0, chars);
        }
        return res.toArray(new String[0]);
    }

    private void backTrace(Set<String> res, char[] tmp, int i, boolean[] visited, int index, char[] chars) {
        if (index >= tmp.length) {
            res.add(new String(tmp));
            return;
        }
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        tmp[index] = chars[i];
        for (int j = 0; j < chars.length; j++) {
            backTrace(res, tmp, j, visited, index + 1, chars);
        }
        visited[i] = false;
    }
}
