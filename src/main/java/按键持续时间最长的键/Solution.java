package 按键持续时间最长的键;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int length=releaseTimes.length;
        char[] keys=keysPressed.toCharArray();
        char key=keys[0];
        int maxTime=releaseTimes[0];
        for (int i = 1; i <length ; i++) {
            int releaseTime=releaseTimes[i]-releaseTimes[i-1];
            if(releaseTime>maxTime||(releaseTime==maxTime&&(keys[i]-'0')>(key-'0'))){
                key=keys[i];
                maxTime=releaseTime;
            }
        }
        return key;
    }
}
