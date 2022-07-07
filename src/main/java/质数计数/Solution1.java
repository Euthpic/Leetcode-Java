package 质数计数;

import java.util.Arrays;

public class Solution1 {
    public int countPrimes(int n) {
        int count=0;
        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                count++;
            }
            if((long)i*i<n){
                for (int j = i*i; j <n ; j+=i) {
                    isPrime[j]=false;
                }
            }

        }
        return count;
    }
}
