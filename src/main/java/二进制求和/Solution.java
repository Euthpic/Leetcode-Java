package 二进制求和;

/**
 * 1.补齐字符串位数之后方便逐位操作,这里可以反转字符串
 * 2. 当前位相加结果= (a+b+carry) % 2
 *  进位carry= (a+b+carry)/2
 */
public class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            carry += i <= a.length() - 1 ? a.charAt(a.length() - 1 - i) - '0' : 0;
            carry += i <= b.length() - 1 ? b.charAt(b.length() - 1 - i) - '0' : 0;
            res.append(carry % 2);
            carry /= 2;
        }
        if (carry > 0) {
            res.append('1');
        }
        return res.reverse().toString();
    }
}
