import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int target=nums.length/2+1;
        for (int i = 0; i <nums.length ; i++) {
            int num=nums[i];
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
                if (map.get(num)>=target){
                    return num;
                }
            }
        }
        int maxCount=0;
        int maxNum=0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue()>maxCount){
                maxCount=integerIntegerEntry.getValue();
                maxNum=integerIntegerEntry.getKey();
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums={3,3,4};
        Solution solution=new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
