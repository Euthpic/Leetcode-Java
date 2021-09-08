package 跳跃游戏2;

/**
 * 这两天做了几条回溯的题,所以这题一开始也是想用回溯来解决
 * 不过仔细分析,回溯要的结果是[路径各个节点的详情],而本题只需要[最短路径的距离],不需要关注每一步怎么走.
 * 所以本题可以用贪心,每一步只需确认本次能到达的最小距离和最大距离,以此确定下一步的起跳范围
 */
public class Solution {


    public int jump(int[] nums) {
        //跳跃步数
        int res=0;
        //起跳范围的起点
        int start=0;
        //起跳范围的终点
        int end=0;
        while (end<nums.length-1){
            //本次跳跃能达到的最远距离,初始化0
            int maxPos=0;
            //每次跳跃能产生一个最小距离和一个最大距离,下一次跳跃的起跳范围就在这两个距离之间
            for (int i = start; i <=end ; i++) {
                //i是当前位置,nums[i]是当前位置能跳跃到的最远位置
                    maxPos=Math.max(maxPos,i+nums[i]);
            }
            //上面的循环已经把本次各个起跳点( start ~ end )能达到的最远距离算出来,所以下次起跳点要从end+1开始
            //下一次起跳范围是[end+1,maxPos]
            start=end+1;
            end=maxPos;
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1,1,1};
        System.out.println("res:" + new Solution().jump(nums));
    }
}
