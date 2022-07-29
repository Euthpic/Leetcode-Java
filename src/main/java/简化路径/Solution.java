package 简化路径;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String str : strs) {
            if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else if (str.length() > 0 && !str.equals(".")) {
                deque.addLast(str);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : deque) {
                stringBuilder.append("/").append(s);
            }
            return stringBuilder.toString();
        }
    }


}
