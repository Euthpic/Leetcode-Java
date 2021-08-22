package 外观数列;

public class Solution {
    public static String countAndSay(int n) {
        String res="1";
        for (int i = 1; i <n ; i++) {
            StringBuilder sb=new StringBuilder();
            int count=1;
            char pre=res.charAt(0);
            for (int j = 1; j <res.length() ; j++) {
                if(res.charAt(j)==pre){
                    count++;
                }else {
                    sb.append(count).append(pre);
                    count=1;
                    pre=res.charAt(j);
                }
            }
            sb.append(count).append(pre);
            res=sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

}
