package 螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 按层模拟
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return res;

        int top=0;
        int left=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;
        while (left<=right && top<=bottom){
            //向右
            for (int column = left; column <=right ; column++) {
                res.add(matrix[top][column]);
            }
            //向下
            for (int row = top+1; row <=bottom ; row++) {
                res.add(matrix[row][right]);
            }
            //left=right表示该层只有一列,top=bottom表示该层只有一行,这种情况下只需向右再下遍历即可,若继续向左或向下遍历会重复
            if(left<right && top<bottom){
                //向左
                for (int column = right-1; column >= left ; column--) {
                    res.add(matrix[bottom][column]);
                }
                //向上
                for (int row = bottom-1; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            //往内层收缩
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
