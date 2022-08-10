package 第N个泰波那契数;

public class Solution {
    int[] cache=new int[40];
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        if(cache[n]!=0){
            return cache[n];
        }
        cache[n]=tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        return cache[n];
    }
}
