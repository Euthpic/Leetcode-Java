package 水壶问题;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//优化后的bfs
public class Solution2 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z <= 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == z) {
                return true;
            }
            Set<Integer> set = new HashSet<>();
            set.add(n + x);
            set.add(n - x);
            set.add(n + y);
            set.add(n - y);
            for (Integer next : set) {
                if (next >= 0 && next <= x + y && visited.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}
