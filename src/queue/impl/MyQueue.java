package queue.impl;

import java.util.ListIterator;
import java.util.Stack;

public class MyQueue<T> {
    private final Stack<T> stack;
    private final Stack<T> stack2;

    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public synchronized void push(T t) {
        stack.push(t);
    }

    public synchronized T pop() {
        if (stack2.isEmpty()) {
            swap(stack, stack2);
        }
        return stack2.pop();
    }

    private void swap(Stack<T> src, Stack<T> des) {
        while (!src.isEmpty()) {
            des.push(src.pop());
        }
    }

    private void cloneInReverse(Stack<T> src, Stack<T> des) {
        ListIterator<T> iterator = stack.listIterator(stack.size());
        while (iterator.hasPrevious()) {
            des.push(iterator.previous());
        }
    }
}
