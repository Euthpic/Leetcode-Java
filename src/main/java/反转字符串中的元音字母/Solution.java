package 反转字符串中的元音字母;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {



    public static String reverseVowels(String s) {
        if(s.length()<=1){
            return  s;
        }
        char[] chars=s.toCharArray();
        int i=0;
        int j=chars.length-1;
        while (i<j&&i<chars.length-1){
            while (!isVowel(chars[i])&&i<j){
                i++;
            }
            while(!isVowel(chars[j])&&i<j){
                j--;
            }
            if(i<j){
                swap(chars,i,j);
                i++;
                j--;
            }
        }
    return String.valueOf(chars);
    }

    public static boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch)>=0;
    }

    public static void swap(char[] chars,int i,int j){
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));

    }
}
