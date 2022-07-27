package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueue_225 {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
    }


}

class MyStack {
    private Deque<Integer> deque;

    public MyStack() {
        deque = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        deque.addLast(x);
    }

    public int pop() {
        int size = deque.size();
        size--;

        // 将 que1 导入 que2 ，但留下最后一个值
        while(size-- > 0) {
            deque.addLast(deque.peekFirst());
            deque.pollFirst();
        }

        int res = deque.pollFirst();
        return res;
    }

    public int top() {
        return deque.peekLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
