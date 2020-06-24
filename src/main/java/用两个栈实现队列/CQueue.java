package 用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;


public class CQueue {
    private Deque<Integer> in;
    private Deque<Integer> out;

    public CQueue() {
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (in.isEmpty() && out.isEmpty()) {
            return -1;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
