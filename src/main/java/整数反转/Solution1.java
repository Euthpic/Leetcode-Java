package 整数反转;

import java.util.LinkedList;

public class Solution1 {
    public int reverse(int x) {
        if (Math.abs(x)<10){
            if (Math.abs(x)<0){
                return 0;
            }
            return x;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        boolean flag=x<0;
        handle(queue,Math.abs(x));
        StringBuilder builder=new StringBuilder();
        for (int num:queue) {
            builder.append(num);
        }
        if (builder.length()>0){
            String str=builder.toString();
            try {
                int result=Integer.parseInt(str);
                if (flag){
                    result=-result;
                }
                return result;
            }catch (NumberFormatException e){
                return 0;
            }

        }
        throw new IllegalArgumentException();
    }

    void handle(LinkedList<Integer> queue, int x) {

        int mod = x % 10;
        queue.add(mod);
        x = x / 10;
        if (x >= 10) {
            handle(queue, x);
        }else {
            queue.add(x);
        }
    }

    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        int result=solution.reverse(-2147483648);
        System.out.println(result);

    }
}
