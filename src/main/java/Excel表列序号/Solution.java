package Excel表列序号;

//本质是26进制转10进制,特殊之处在于十进制的每一位从1开始,所以转换后每一位都要+1
public class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars=columnTitle.toCharArray();
        int n=chars.length;
        int ans=0;
        for (char aChar : chars) {
            ans = ans * 26 + (aChar - 'A' + 1);
        }
        return ans;
    }
}
