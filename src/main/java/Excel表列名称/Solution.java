package Excel表列名称;
//本质是十进制转26进制,特殊之处在于十进制的每一位从1开始,所以转换前每位要先-1
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while (columnNumber>0){
            //一般的转进制是从0开始,但这里从1开始,所以要先-1
            columnNumber--;
            sb.append((char) (columnNumber%26+'A'));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }
}
