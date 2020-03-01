package 盛最多水的容器;



public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {

            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > result) {
                result = area;
            }
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
