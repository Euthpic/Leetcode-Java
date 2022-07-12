package 最小覆盖子串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    Map<Character, Integer> targetMap = new HashMap<>();
    Map<Character, Integer> currentMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int targetL = -1;
        int targetR = -1;
        int targetLen = Integer.MAX_VALUE;
        int l = 0;
        int r = -1;
        int sLen = s.length();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (r < sLen) {
            //右窗口扩张
            r++;
            if (r < sLen && targetMap.containsKey(s.charAt(r))) {
                currentMap.put(s.charAt(r), currentMap.getOrDefault(s.charAt(r),0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < targetLen) {
                    //如果当前滑动窗口的长度小于原先最小区间的长度,则更新最小区间的长度
                    targetL = l;
                    targetLen = r - l + 1;
                    targetR = targetL + targetLen;
                }
                //左窗口收缩
                if (targetMap.containsKey(s.charAt(l))) {
                    currentMap.put(s.charAt(l), currentMap.getOrDefault(s.charAt(l),0) - 1);
                }
                l++;
            }
        }
        return targetL == -1 ? "" : s.substring(targetL, targetR);
    }

    public boolean check() {
        //判断目前的窗口是否已覆盖子串
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if ( currentMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
