package Excel表列名称;

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
