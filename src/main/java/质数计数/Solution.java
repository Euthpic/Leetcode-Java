package 质数计数;

//枚举，一般会超时
public class Solution {
    public int countPrimes(int n) {
        int count=0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)){
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(int n){
        if(n==1) return false;
        for (int i = 2; i*i <=n; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
