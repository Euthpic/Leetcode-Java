package 栈的压入弹出序列;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        Deque<Integer> queue = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            queue.push(num);
            while (!queue.isEmpty() && queue.peek().equals(popped[i])) {
                queue.pop();
                i++;
            }

        }
        return queue.isEmpty();
    }
}

