package 使数组唯一的最小增量;

import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int move=0;
        for (int i = 1; i < A.length; i++) {
            if (A[i]<=A[i-1]){
                int pre=A[i];
                A[i]=A[i-1]+1;
                move+=A[i]-pre;
            }
        }
        return move;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] A={3,2,1,2,1,7};
        System.out.println(solution.minIncrementForUnique(A));
    }
}
