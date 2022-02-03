package 矩阵置零;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        int length=matrix.length;
        int width=matrix[0].length;
        Set<Integer> l=new HashSet<>();
        Set<Integer> w=new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j]==0){
                    l.add(j);
                    w.add(i);

                }
            }
        }
        for (Integer integer : l) {
            for (int i = 0; i < length; i++) {
                matrix[i][integer]=0;
            }
        }
        for (Integer integer : w) {

            for (int i = 0; i < width; i++) {
                matrix[integer][i]=0;
            }
        }
    }
}
