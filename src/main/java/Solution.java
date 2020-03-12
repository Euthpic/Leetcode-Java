
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String result = "";
        int len = Math.min(str1.length(), str2.length());
            for (int i = 0; i < len; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    break;
                }
                String divisor = str1.substring(0, i + 1);
                if (isDivisible(str1, divisor) && isDivisible(str2, divisor)) {
                result = divisor;
            }
        }
        return result;
    }

    boolean isDivisible(String str2, String str1) {
        if (str2.length() % str1.length() != 0) {
            return false;
        }
        int count = str2.length() / str1.length();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < count; i++) {
            tmp.append(str1);
        }
        return tmp.toString().equals(str2);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String str1="ABCABC";
        String str2="ABC";
        System.out.println(solution.gcdOfStrings(str1,str2));
    }
}
