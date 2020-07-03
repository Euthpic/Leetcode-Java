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
        int j = 0;
        while (i <= pushed.length-1 && j <= popped.length-1) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (!queue.isEmpty() && queue.peek().equals(popped[j])) {
                queue.pop();
                j++;
            } else {
                queue.push(pushed[i++]);
            }
        }
        while (!queue.isEmpty()&&j<=popped.length-1){
            if (!queue.pop().equals(popped[j++])){
                return false;
            }
        }
        return true;
    }
}

