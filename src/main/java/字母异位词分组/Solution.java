package 字母异位词分组;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res=new HashMap<>();
        for (String str : strs) {
            char[] cs=str.toCharArray();
            Arrays.sort(cs);
            String key=String.valueOf(cs);
            List<String> list=res.getOrDefault(key,new ArrayList<>());
            list.add(str);
            res.put(key,list);
        }
        return new ArrayList<>(res.values());
    }
}
