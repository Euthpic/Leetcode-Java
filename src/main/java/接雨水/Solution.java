package 接雨水;

import java.util.Stack;

public class Solution {

    public int trap(int[] height) {
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        int cur=0;
        while (cur<height.length){
            while (!stack.isEmpty()&&height[stack.peek()]<height[cur]){
                //积水的底部高度
                int h=height[stack.peek()];
                stack.pop();

                if(stack.isEmpty()){
                    break;
                }
                int min=Math.min(height[stack.peek()],height[cur]);
                int distance=cur-stack.peek()-1;
                sum+=distance*(min-h);
            }

            stack.push(cur);
            cur++;
        }
        return sum;
    }
}
