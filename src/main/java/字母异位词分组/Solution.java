package 字母异位词分组;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res=new HashMap<>();
        for (String str : strs) {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            List<String> list=res.getOrDefault(key,new ArrayList<>());
            list.add(str);
            res.put(key,list);
        }
        return new ArrayList<>(res.values());
    }
}
