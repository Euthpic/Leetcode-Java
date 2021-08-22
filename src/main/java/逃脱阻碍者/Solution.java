package 逃脱阻碍者;

/**
 * 如果不存在一个ghost的曼哈顿距离小于等于自己的曼哈顿距离,则结果为true
 * 曼哈顿距离dist=| x-targetX | + | y-targetY |
 */
public class Solution {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] arr={0,0};
        int dist=dist(target[0],target[1],arr);
        for (int[] ghost : ghosts) {
            if(dist(ghost[0],ghost[1],target)<=dist){
                return false;
            }
        }
        return true;
    }

    public int dist(int x,int y,int[] target){
        return Math.abs(x-target[0])+Math.abs(y-target[1]);
    }

    public static void main(String[] args) {

    }
}
