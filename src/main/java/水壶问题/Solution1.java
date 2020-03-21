package 水壶问题;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//广度优先搜索bfs,未优化
public class Solution1 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z <= 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> initStatus = new Pair<>(0, 0);
        queue.offer(initStatus);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> target = queue.poll();
            if (target.getKey() + target.getValue() == z || target.getKey() == z || target.getValue() == z) {
                return true;
            }
            Set<Pair<Integer, Integer>> nextStatusSet = getNextStatus(target.getKey(), target.getValue(), x, y);
            for (Pair<Integer, Integer> nextStatus : nextStatusSet) {
                //去重
                if (visited.add(nextStatus)) {
                    queue.offer(nextStatus);
                }
            }
        }
        return false;
    }

    private Set<Pair<Integer, Integer>> getNextStatus(int preX, int preY, int x, int y) {
        //从外界倒满x
        Pair<Integer, Integer> nextStatus1 = new Pair<>(x, preY);
        //从外界倒满y
        Pair<Integer, Integer> nextStatus2 = new Pair<>(preX, y);
        //向外界倒空x
        Pair<Integer, Integer> nextStatus3 = new Pair<>(0, preY);
        //向外界倒空y
        Pair<Integer, Integer> nextStatus4 = new Pair<>(preX, 0);
        //x向y倒直到x空
        Pair<Integer, Integer> nextStatus5 = new Pair<>(0, preY + preX);
        //x向y倒直到y满
        Pair<Integer, Integer> nextStatus6 = new Pair<>(preX + preY - y, y);
        //y向x倒直到y空
        Pair<Integer, Integer> nextStatus7 = new Pair<>(preX + preY, 0);
        //y向x倒直到x满
        Pair<Integer, Integer> nextStatus8 = new Pair<>(x, preX + preY - x);
        //下个状态空间
        Set<Pair<Integer, Integer>> nextStatusSet = new HashSet<>();
        if (preX < x) {
            nextStatusSet.add(nextStatus1);
        }
        if (preY < y) {
            nextStatusSet.add(nextStatus2);
        }
        if (preX > 0) {
            nextStatusSet.add(nextStatus3);
        }
        if (preY > 0) {
            nextStatusSet.add(nextStatus4);
        }
        if (preY > 0) {
            nextStatusSet.add(nextStatus4);
        }
        if (preX + preY < y) {
            nextStatusSet.add(nextStatus5);
        }
        if (preX + preY >= y) {
            nextStatusSet.add(nextStatus6);
        }
        if (preX + preY < x) {
            nextStatusSet.add(nextStatus7);
        }
        if (preX + preY >= x) {
            nextStatusSet.add(nextStatus8);
        }
        return nextStatusSet;
    }
}
