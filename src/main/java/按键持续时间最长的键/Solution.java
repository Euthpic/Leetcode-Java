package 按键持续时间最长的键;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character,Integer> map=new HashMap<>();
        int length=releaseTimes.length;
        char[] keys=keysPressed.toCharArray();
        map.put(keys[0],releaseTimes[0]);
        for (int i = 1; i <length ; i++) {
            if (map.containsKey(keys[i])){
                map.put(keys[i],releaseTimes[i]-releaseTimes[i-1]+map.get(keys[i]));
            }else {
                map.put(keys[i],releaseTimes[i]-releaseTimes[i-1]);
            }
        }
        char key=keys[0];
        int maxTime=releaseTimes[0];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()>maxTime){
                key=entry.getKey();
                maxTime=entry.getValue();
            }else if(entry.getValue()==maxTime&&(entry.getKey()-'0')>(key-'0')){
                key=entry.getKey();
                maxTime=entry.getValue();
            }
        }
        return key;
    }
}
