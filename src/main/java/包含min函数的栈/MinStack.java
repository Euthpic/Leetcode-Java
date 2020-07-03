package 包含min函数的栈;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private Deque<Integer> a;
    private Deque<Integer> b;
    public MinStack() {
        a=new LinkedList<>();
        b=new LinkedList<>();
    }

    public void push(int x) {
        a.push(x);
        if (b.isEmpty()||x<=b.peek()){
            b.push(x);
        }
    }

    public void pop() {
        if (a.isEmpty()){
            return;
        }
        if (a.pop().equals(b.peek())){
            b.pop();
        }
    }

    public int top() {
        if (a.isEmpty()){
            return Integer.MIN_VALUE;
        }
       return a.peek();
    }

    public int min() {
        if (b.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return b.peek();
    }
}
