package 插入区间;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public  int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null|| intervals.length==0) return new int[][]{newInterval};

        int l=newInterval[0];
        int r=newInterval[1];
        boolean placed=false;
        List<int[]> merged=new LinkedList<>();
        for (int[] interval : intervals) {
            if(interval[0]>r){
                //要插入的区间在当前左侧
                if(!placed){
                    //如果之前还未插入过则插入
                    merged.add(new int[]{l,r});
                    placed=true;
                }
                merged.add(interval);
            }else if(interval[1]<l){
                //要插入的区间在当前右侧
                merged.add(interval);
            }else{
                //合并区间
                l=Math.min(interval[0],l);
                r=Math.max(interval[1],r);
            }
        }

        if(!placed){
            //如果遍历完还未插入则最后插入
            merged.add(new int[]{l,r});
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
