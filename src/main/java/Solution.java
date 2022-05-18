import java.util.*;

/**
 * 重复练习
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
       Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
    return -1;
    }
}
