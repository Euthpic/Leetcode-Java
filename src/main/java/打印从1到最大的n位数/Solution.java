package 打印从1到最大的n位数;

public class Solution {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }
        int count = (int) Math.pow(10, n) - 1;
        int res[] = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = i + 1;
        }
        return res;
    }


}
