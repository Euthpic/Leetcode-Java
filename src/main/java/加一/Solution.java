package 加一;


/**
 * 加一操作要注意的就是进位
 * 1.如果末尾第一个数不为9,那么直接+1
 * 2.倒序遍历,找到第一个不为9的数,该位+1,然后后面全部置0
 * 3.特别的,如果数组全部为9,那么需要构造长度+1的新数组
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                //从末尾开始找,找到第一个不为9的数
                digits[i] += 1;
                for (int j = i+1; j < len; j++) {
                    //该位后面全部置0
                    digits[j] = 0;
                }
                return digits;
            }

        }
        //如果全为9,比如999,那么构建一个len+1的数组,比如1000
        int[] res = new int[len+1];
        res[0]=1;
        return res;
    }
}
