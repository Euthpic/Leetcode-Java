package 回文数;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x<0){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int i = 0;
        int j = list.size() - 1;
        boolean result = true;
        while (i <= j) {
            int before = list.get(i);
            int after = list.get(j);
            i++;
            j--;
            if (before != after) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        System.out.println(solution.isPalindrome(-121));
    }
}
